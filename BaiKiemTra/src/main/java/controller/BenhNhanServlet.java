package controller;

import model.BenhAn;
import model.BenhNhan;
import repository.IBenhNhanRepository;
import repository.imp.BenhNhanhRepository;
import service.IBenhNhanService;
import service.imp.BenhNhanService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BenhNhanServlet", value = "/benhnhan")
public class BenhNhanServlet extends HttpServlet {
    IBenhNhanService benhNhanService = new BenhNhanService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showeditForm(request,response);
                break;
            case "delete":
                doDeleteForm(request,response);
                break;
            case "view":
                showViewForm(request,response);
                break;
            case "search":
                doSearch(request,response);
                break;
            default:
                listBenhNhan(request,response);
                break;
        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) {
        String inputSearch = request.getParameter("inputSearch");
        List<BenhNhan> listSearch = new ArrayList<>();
        BenhNhanhRepository.findByName(inputSearch);
        for(BenhNhan benhNhan: benhNhanService.getAll()){
            if(benhNhan.getTenBenhNhan().toLowerCase().contains(inputSearch.toLowerCase())){
                listSearch.add(benhNhan);
            }
        }
        RequestDispatcher dispatcher;
        if(listSearch==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("listSearch", listSearch);
            dispatcher = request.getRequestDispatcher("benhnhan/list.jsp");
        }
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String maBN =request.getParameter("id");
        String maBA = request.getParameter("maBA");
        BenhNhan benhNhan = benhNhanService.findById(maBN,maBA);
        RequestDispatcher dispatcher;
        if(benhNhan==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("benhnhan", benhNhan);
            dispatcher = request.getRequestDispatcher("benhnhan/view.jsp");
        }
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String maBN =request.getParameter("id");
        String maBA = request.getParameter("maBA");
        benhNhanService.deleteById(maBN,maBA);
        try {
            response.sendRedirect("/benhnhan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showeditForm(HttpServletRequest request, HttpServletResponse response) {
        String maBN =request.getParameter("id");
        String maBA = request.getParameter("maBA");
        BenhNhan benhNhan = benhNhanService.findById(maBN,maBA);
        RequestDispatcher dispatcher;
        List<BenhAn> listBA = benhNhanService.getAllBenhAn();
        if(benhNhan==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("benhnhan", benhNhan);
            request.setAttribute("listBA",listBA);
            dispatcher = request.getRequestDispatcher("benhnhan/edit.jsp");
        }
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> listBA = benhNhanService.getAllBenhAn();
        request.setAttribute("listBA",listBA);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("benhnhan/create.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void listBenhNhan(HttpServletRequest request, HttpServletResponse response) {
        List<BenhNhan> list = benhNhanService.getAll();
        request.setAttribute("listBenhNhan",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhnhan/list.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                    createBenhNhan(request,response);
                break;
            case "edit":
                    editBenhNhan(request, response);
                break;
            default:
                break;
        }
    }

    private void editBenhNhan(HttpServletRequest request, HttpServletResponse response) {
        String maBN = request.getParameter("maBN");
        String tenBN = request.getParameter("tenBN");
        String maBA = request.getParameter("maBA");
        String ngayNV = request.getParameter("ngayNV");
        String ngayRV = request.getParameter("ngayRV");
        String lyDo = request.getParameter("lyDo");

        BenhNhan benhNhan = new BenhNhan(maBN,tenBN,ngayNV,ngayRV,lyDo,maBA);
        benhNhanService.update(benhNhan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhnhan/edit.jsp");
        request.setAttribute("message", "Tao moi benh nhan thanh cong");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createBenhNhan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBN = request.getParameter("maBN");
        String tenBN = request.getParameter("tenBN");
        String maBA = request.getParameter("maBA");
        String ngayNV = request.getParameter("ngayNV");
        String ngayRV = request.getParameter("ngayRV");
        String lyDo = request.getParameter("lyDo");

        BenhNhan benhNhan = new BenhNhan(maBN,tenBN,ngayNV,ngayRV,lyDo,maBA);
        benhNhanService.insert(benhNhan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("benhnhan/create.jsp");
        request.setAttribute("message", "Tao moi benh nhan thanh cong");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
