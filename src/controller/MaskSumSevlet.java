package controller;

import dao.OrderDataDaoImp;
import domain.Order;
import service.MaskSumService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MaskSumSevlet")
public class MaskSumSevlet extends HttpServlet {
    MaskSumService maskSumService = new MaskSumService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("maskSum");
        maskSumService.updateMaskSum(Integer.parseInt(parameter));
    }
}
