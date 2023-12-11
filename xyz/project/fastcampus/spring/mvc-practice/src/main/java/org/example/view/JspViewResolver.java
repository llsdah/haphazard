package org.example.view;

import static org.example.view.RedirectView.DEFAULT_REDIRECT_PREFIX;

public class JspViewResolver implements ViewResolver{
    @Override
    public View resolverView(String viewName) {
        if(viewName.startsWith(DEFAULT_REDIRECT_PREFIX)){
            return new RedirectView(viewName);
        }else{
            return new JspView(viewName+".jsp");
        }
    }
}
