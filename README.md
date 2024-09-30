This project focuses on implementing cryptanalysis attacks exploiting the misuse of the One-Time Pad (OTP) cipher. The goal is to demonstrate vulnerabilities in symmetric cryptography through two distinct scenarios involving ciphertexts generated with the same random sequence.

## Features

    Cryptanalysis Implementation: Develops methods to recover plaintexts from ciphertexts using known vulnerabilities in OTP.
    Binary Input Handling: Accepts ciphertexts in binary format for processing.
    ASCII Encoding: Assumes that messages are encoded in ASCII.
    Variable Length Handling: Capable of processing messages of differing lengths.

Scenario 1 

    Objective: Given two ciphertexts C1C1​ and C2C2​ created using the same random sequence, and knowing the plaintext corresponding to C1C1​, the program will derive the plaintext for C2C2​.
    Input: The program accepts binary ciphertexts.
    Assumption: Messages may not be of equal length, requiring special handling.

Scenario 2 

    Objective: Similar to Scenario 1, but with additional information about both plaintexts.
    Assumptions for Messages:
        Both messages consist solely of decimal numbers.
        One message consists only of decimal numbers while the other contains only English letters.
    Input: The program accepts binary ciphertexts.
    Assumption: Messages may not be of equal length, and multiple valid plaintexts may exist.
