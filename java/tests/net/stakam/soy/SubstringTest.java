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
public class SubstringTest {

    @Test
    public void testComputeForJsSrc() {

        Substring f = new Substring();
        JsExpr arg0 = new JsExpr("JS_VAR", Integer.MAX_VALUE);
        JsExpr arg1 = new JsExpr("1", Integer.MAX_VALUE);
        JsExpr arg2 = new JsExpr("2", Integer.MAX_VALUE);
        
        assertEquals(
            new JsExpr("JS_VAR.toString().substring(1)", Integer.MAX_VALUE),
            f.computeForJsSrc(ImmutableList.of(arg0, arg1)));

        assertEquals(
            new JsExpr("JS_VAR.toString().substring(1,2)", Integer.MAX_VALUE),
            f.computeForJsSrc(ImmutableList.of(arg0, arg1, arg2)));
    }

    @Test
    @Ignore
    public void testComputeForJavaSrc() {
        // TODO: Write test.
        // assertEquals("aaa", "aaa");
    }
}
