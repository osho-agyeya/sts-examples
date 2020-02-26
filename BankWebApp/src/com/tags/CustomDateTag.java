package com.tags;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomDateTag extends TagSupport {


    public int doStartTag() throws JspException {
        LocalDateTime dateTime = LocalDateTime.now();
        String dateTimeStr = dateTime.toString();
        JspWriter writer = this.pageContext.getOut();
        try {
            writer.println("<p> Current DateTime" + dateTimeStr + "</p>");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Tag.EVAL_PAGE;
    }

    public int doAfterBody() throws JspException {
        // TODO Auto-generated method stub
        return super.doAfterBody();
    }

    public int doEndTag() throws JspException {
        // TODO Auto-generated method stub
        return super.doEndTag();
    }


}
