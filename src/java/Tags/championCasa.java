/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tags;

import JDBC.AccesoJDBC;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author alumno
 */
public class championCasa extends TagSupport{

    private AccesoJDBC jdbc;
    
    @Override
    public int doStartTag() throws JspException {
        jdbc = new AccesoJDBC();
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            ResultSet rs = jdbc.getResultados("CHAMPION", "CASA");
            ResultSetMetaData rsmd = rs.getMetaData();
            JspWriter jw = pageContext.getOut();
            if (rs.next()){
                jw.write("<tr>");
                for (int i = 1; i <= rsmd.getColumnCount(); i++){
                    jw.write("<td bgcolor=\"#99FF99\">"+AccesoJDBC.capitalize(rsmd.getColumnName(i))+"</td>");
                }
                jw.write("</tr>");
                do{
                    jw.write("<tr bgcolor=\"#FFFF99\">");
                    for (int i = 1; i <= rsmd.getColumnCount(); i++){
                        jw.write("<td"+((i==3)?" align=\"center\"":"")+">"+rs.getString(i)+"</td>");
                    }
                    jw.write("</tr>");
                } while (rs.next());
            }
        } catch (Exception e){
            throw new JspTagException("Excepcion: "+e.toString());
        }
        return EVAL_PAGE;
    }
    
}
