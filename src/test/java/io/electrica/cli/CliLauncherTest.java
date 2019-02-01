package io.electrica.cli;

import org.junit.jupiter.api.Test;

class CliLauncherTest {

    @Test
    void testHelp() {
        CliLauncher.main(new String[]{"--help"});
    }
}
