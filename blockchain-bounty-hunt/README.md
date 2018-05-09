# Blockchain Bounty Hunter

The first exercise for Week 2 starts us down the path of blockchain exploration. 

In this exercise, you will write a program that will pull in a series of blocks from the Bitcoin blockchain confirmed. You will then parse the transactions in those blocks to see if they meet a certain criteria. If they do, you will print or log that transaction. Within that transaction will be a message.

## Blockchain Data API

To save resources, we'll use a third-party API to make requests. [Here is the API documentation for Blockchain.info](https://blockchain.info/api/blockchain_api) and below are the calls we recommend you use:

### Single Block

https://blockchain.info/rawblock/$block_hash 

You can also request the block to return in binary form (Hex encoded) using ?format=hex 

### Single Transaction

https://blockchain.info/rawtx/$tx_hash 

You can also request the transaction to return in binary form (Hex encoded) using ?format=hex 


## Parsing

The transaction has a `txid` that ends with the six characters `04dfa3`. It was mined sometime between on April 30th and May 2nd, 2018.

**_Hint: API request limits for Blockchain.info are 28k requests per 8 hrs and 600 requests per 5m. Ping wisely..._**

Happy hunting!


---

*Exploratory Extra Credit:*

### Unconfirmed Transactions

https://blockchain.info/unconfirmed-transactions?format=json

### Blocks

Blocks for one day: https://blockchain.info/blocks/$time_in_milliseconds?format=json
Blocks for specific pool: https://blockchain.info/blocks/$pool_name?format=json

