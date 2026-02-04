package com.example.apiinternal.cli

import org.springframework.stereotype.Component
import picocli.CommandLine.Command

@Component
@Command(
    name = "batch",
    description = ["Batch jobs"],
    mixinStandardHelpOptions = true,
    subcommands = [BatchSampleCommand::class],
)
class BatchCommand : Runnable {
    override fun run() {
        // Subcommands only
    }
}
