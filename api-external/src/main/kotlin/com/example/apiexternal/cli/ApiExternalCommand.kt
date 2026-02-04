package com.example.apiexternal.cli

import org.springframework.stereotype.Component
import picocli.CommandLine.Command

@Component
@Command(
    name = "api-external",
    description = ["api-external CLI commands"],
    mixinStandardHelpOptions = true,
    subcommands = [BatchCommand::class],
)
class ApiExternalCommand : Runnable {
    override fun run() {
        // Root command prints help by default
    }
}
