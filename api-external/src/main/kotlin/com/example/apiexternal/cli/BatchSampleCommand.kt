package com.example.apiexternal.cli

import com.example.apiexternal.service.BatchService
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.concurrent.Callable
import org.springframework.stereotype.Component
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Component
@Command(
    name = "sample",
    description = ["Sample batch command"],
    mixinStandardHelpOptions = true,
)
class BatchSampleCommand(
    private val service: BatchService,
    private val objectMapper: ObjectMapper,
) : Callable<Int> {
    @Option(names = ["--limit"], defaultValue = "100", description = ["Maximum items to process"])
    private var limit: Int = 100

    @Option(names = ["--json"], defaultValue = "false", description = ["Output JSON"])
    private var jsonOutput: Boolean = false

    override fun call(): Int {
        val result = service.process(limit)
        if (jsonOutput) {
            println(objectMapper.writeValueAsString(result.toMap()))
        } else {
            println(result.message)
        }
        return 0
    }
}
