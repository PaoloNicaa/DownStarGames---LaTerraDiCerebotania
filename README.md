# DownStarGames---SurvivalGame

--- DA AGGIUNGERE ---
1. Terminare metodo per raccolta oggetti da usare in SurvivalGameGUI riga 221.
2. Agginta di un message dialog funzionante come visualizzatore di inventario.
3. Aggingere che dopo la raccolta degli stivali le mosse aumentano di 10 o piu.
4. (OPZIONALE) Ho notato che c'è un problema con la chiusura della GUI che nonostante ci sia la DefaultCloseOperation(EXIT_ON_CLOSE) parte del programma rimane comunque in background, se qualcuno riesce a capire come 
   risolvere mi farebbe un favore.


--- CONSIGLI ---

Per il metodo raccolta oggetti prendere le coordinate attuali del player e dell'item a cui è piu vicino e se la differenza è tra 0 e 50 l'item verra aggiunto all'inventario,
questa logica andra implementata nel metodo player.collectItem che viene gia utilizzato nella GUI.
