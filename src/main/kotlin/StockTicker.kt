import com.ib.client.Contract

class StockTicker private constructor(private val tickerString: String, private val primaryExchange: String) {
    companion object {
        private val lookup = mutableMapOf<String, StockTicker>()

        fun register(tickerString: String, primaryExchange: String): StockTicker {
            val ticker = StockTicker(tickerString, primaryExchange)
            lookup[tickerString.lowercase()] = ticker
            return ticker
        }

        operator fun get(tickerString: String) = lookup[tickerString.lowercase()]
    }

    fun createContract(): Contract {
        val contract = Contract()
        contract.symbol(tickerString)
        contract.secType("STK")
        contract.currency("USD")
        contract.exchange("SMART")
        contract.primaryExch(primaryExchange)
        return contract
    }

    override fun toString() = tickerString
}

val AVLV = StockTicker.register("AVLV", "ARCA")
val AVUV = StockTicker.register("AVUV", "ARCA")
val AVIV = StockTicker.register("AVIV", "ARCA")
val AVDV = StockTicker.register("AVDV", "ARCA")
val AVES = StockTicker.register("AVES", "ARCA")
