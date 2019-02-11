package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spec.gebish.GebishOrgSpec;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GebishOrgSpec.class
})

public class GebishSuite {
}