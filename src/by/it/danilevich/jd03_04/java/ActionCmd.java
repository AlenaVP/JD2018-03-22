package by.it.danilevich.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public interface ActionCmd {
    String execute(HttpServletRequest reg) throws Exception;


}