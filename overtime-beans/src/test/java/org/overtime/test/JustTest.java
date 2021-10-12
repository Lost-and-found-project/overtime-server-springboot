package org.overtime.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.overtime.beans.CompensateType;

/**
 * @author ForteScarlet
 */
@Testable
public class JustTest {

    @Test
    public void aTest() {
        CompensateType compensateType = new CompensateType();

        System.out.println("Init");

        System.out.println(compensateType);
        System.out.println(compensateType.getCreateTime());

        // compensateType.setCreateTime(null);

    }

}
