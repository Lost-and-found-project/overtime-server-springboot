package org.overtime.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.overtime.beans.A;

/**
 * @author ForteScarlet
 */
@Testable
public class JustTest {

    @Test
    public void aTest() {
        A a = new A("Forte");
        final A b = a.copy();
        final A c = b.copy();

        a.changeName(b, c, "forli");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

}
