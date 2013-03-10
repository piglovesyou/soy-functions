package net.stakam.soy;

import java.util.List;
import java.util.Set;
import com.google.common.collect.ImmutableSet;
import com.google.template.soy.jssrc.restricted.JsExpr;
import com.google.template.soy.jssrc.restricted.SoyJsSrcFunction;


class FormatNumberWithComma implements SoyJsSrcFunction 
{
    @Override public String getName() { 
        return "formatNumberWithComma";
    } 
    
    @Override public Set<Integer> getValidArgsSizes() { 
        return ImmutableSet.of(1); 
    } 
    
    @Override public JsExpr computeForJsSrc(List<JsExpr> args) { 
        String input = args.get(0).getText();
        return new JsExpr(
            input + ".toString().replace(/\\B(?=(\\d{3})+(?!\\d))/g,',')",
            Integer.MAX_VALUE); 
    } 
    
    // TODO: Implement.
    // @Override public JavaExpr computeForJavaSrc(List<JavaExpr> args) {
    // }
} 
