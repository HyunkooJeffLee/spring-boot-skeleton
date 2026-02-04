package com.example.apiinternal.cli

import org.springframework.stereotype.Component
import picocli.CommandLine.Command

@Component
@Command(
    name = "api-internal",
    description = ["api-internal CLI commands"],
    mixinStandardHelpOptions = true,
    subcommands = [BatchCommand::class],
)
class ApiInternalCommand : Runnable {
    override fun run() {
        // Root command prints help by default
    }
}
