package io.github.guisso.jakartaee8.jsffaceletstemplate;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Luis Guisso <luis.guisso at ifnmg.edu.br>
 */
@Named
@ApplicationScoped
public class Util
        implements Serializable {

    public String canItBeRendered(String page) {
        FacesContext context = FacesContext.getCurrentInstance();
        String expression = "#{view.viewId"
                + ".replace('/', '')"
                + ".replace('.xhtml','') ne '" + page + "'}";
        String rendered = context.getApplication()
                .evaluateExpressionGet(
                        context,
                        expression,
                        String.class);
        System.out.println(">>> Rendered? " + expression + " > " + rendered);
        return rendered;
    }

}
