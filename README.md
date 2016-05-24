## Implemention of huffman coding in Java

1. To get character encoding using huffman

        String sampleSentence = "Welcome to huffman encoding project";

        HuffmanEncoder huffmanEncoder = new HuffmanEncoder(sampleSentence);

        Map<Character, byte[]> characterEncoding = huffmanEncoder.getCharacterEncoding();



