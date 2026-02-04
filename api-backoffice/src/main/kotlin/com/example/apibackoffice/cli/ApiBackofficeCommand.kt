package com.example.apibackoffice.cli

import org.springframework.stereotype.Component
import picocli.CommandLine.Command

@Component
@Command(
    name = "api-backoffice",
    description = ["api-backoffice CLI commands"],
    mixinStandardHelpOptions = true,
    subcommands = [BatchCommand::class],
)
class ApiBackofficeCommand : Runnable {
    override fun run() {
        // Root command prints help by default
    }
}
