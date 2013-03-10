package net.stakam.soy;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.template.soy.data.SoyData;
import com.google.template.soy.data.restricted.BooleanData;
import com.google.template.soy.data.restricted.StringData;
import com.google.template.soy.exprtree.Operator;
import com.google.template.soy.javasrc.restricted.JavaExpr;
import com.google.template.soy.jssrc.restricted.JsExpr;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Foo}.
 */
@RunWith(JUnit4.class)
public class FormatNumberWithCommaTest {

    @Test
    public void testComputeForJsSrc() {

        FormatNumberWithComma f = new FormatNumberWithComma();
        JsExpr arg0 = new JsExpr("JS_VAR", Integer.MAX_VALUE);
        
        assertEquals(
            new JsExpr("JS_VAR.toString().replace(/\\B(?=(\\d{3})+(?!\\d))/g,',')", Integer.MAX_VALUE),
            f.computeForJsSrc(ImmutableList.of(arg0)));
    }

    @Test
    @Ignore
    public void testComputeForJavaSrc() {
        // TODO: Write test.
        // assertEquals("aaa", "aaa");
    }
}
