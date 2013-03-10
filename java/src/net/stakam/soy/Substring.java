package net.stakam.soy;

import java.util.List;
import java.util.Set;
import com.google.common.collect.ImmutableSet;
import com.google.template.soy.jssrc.restricted.JsExpr;
import com.google.template.soy.jssrc.restricted.SoyJsSrcFunction;


class Substring implements SoyJsSrcFunction 
{
    @Override public String getName() { 
        return "substring";
    } 
    
    @Override public Set<Integer> getValidArgsSizes() { 
        return ImmutableSet.of(2, 3); 
    } 
    
    @Override public JsExpr computeForJsSrc(List<JsExpr> args) { 
        String str = args.get(0).getText();
        String from = args.get(1).getText();
        String to = args.size() > 2 ? args.get(2).getText() : null;
    
        return new JsExpr(
              str + ".toString().substring(" + from +
              (to != null ? "," + to : "") + ")", Integer.MAX_VALUE); 
    } 
    
    // TODO: Implement.
    // @Override public JavaExpr computeForJavaSrc(List<JavaExpr> args) {
    // }
} 
