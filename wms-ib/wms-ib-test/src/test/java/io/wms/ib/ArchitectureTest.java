package io.wms.ib;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import io.github.dddplus.ArchitectureEnforcer;
import org.junit.Before;
import org.junit.Test;

/**
 * 架构守护神，为架构演进保驾护航，拒绝架构腐化.
 */
public class ArchitectureTest {

    private JavaClasses classes;

    @Before
    public void setUp() {
        classes = new ClassFileImporter()
                .withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages("io.wms.ib");
    }

    @Test
    public void requiredRules() {
        for (ArchRule rule : ArchitectureEnforcer.requiredRules) {
            rule.check(classes);
        }
    }

}