package by.it.poprugo.project.java;

import javax.servlet.http.HttpServletRequest;

public interface ActionCmd {
    String execute(HttpServletRequest reg) throws Exception;
}