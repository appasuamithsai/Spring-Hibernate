package com.amith;

import com.amith.service.AddService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddController {
    @RequestMapping("/add")
    public ModelAndView add( @RequestParam("t1") int i,@RequestParam("t2") int j,HttpServletRequest request, HttpServletResponse response){
//        int i= Integer.parseInt(request.getParameter("t1"));
//        int j= Integer.parseInt(request.getParameter("t2"));
        ModelAndView view=new ModelAndView();
        view.setViewName("display");
        AddService service=new AddService();
        view.addObject("result",service.add(i,j));
        return view;
    }

}
