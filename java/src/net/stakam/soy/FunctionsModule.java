
package net.stakam.soy;

import com.google.template.soy.shared.restricted.SoyFunction;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class FunctionsModule extends AbstractModule
{ 
  @Override public void configure() { 
    Multibinder<SoyFunction> soyFunctionsSetBinder = 
        Multibinder.newSetBinder(binder(), SoyFunction.class); 

    soyFunctionsSetBinder.addBinding().to(Substring.class); 
    soyFunctionsSetBinder.addBinding().to(FormatNumberWithComma.class); 
    soyFunctionsSetBinder.addBinding().to(LiteralApply.class); 
  } 
}
