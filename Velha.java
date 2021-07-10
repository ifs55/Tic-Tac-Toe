

import java.io.IOException;
import java.util.Scanner;

public class Velha {
	
	private int jogador1Vitorias;
	private int jogador2Vitorias;
	private int empates;
	
	private int vez;
	
	private static final int VEZ_JOGADOR_1 = 1;
	private static final int VEZ_JOGADOR_2 = 2;
	
	private static final int OPCAO_JOGAR = 1;
	private static final int OPCAO_RESULTADOS = 2;
	private static final int OPCAO_SAIR = 3;
	private static final int DIMENSAO = 3;
	private static final char SIMBOLO_JOGADOR_1 = 'X';
	private static final char SIMBOLO_JOGADOR_2 = 'O';
	private static final char SIMBOLO_VAZIO = ' ';
	private static final char SIMBOLO_EMPATE = 'E';
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int selecao;
		
		Velha velha = new Velha();
		
		do {
		
			selecao = velha.Menu();
		
			switch (selecao) {
				case OPCAO_JOGAR:
				    velha.Jogar();
					break;
				case OPCAO_RESULTADOS:
					velha.Resultados();
					break;
				case OPCAO_SAIR:
					System.exit(0);
					break;
			}
		
		} while(selecao != OPCAO_SAIR);

	}
	
	public void clearScreen() {  
		//Runtime.exec("clear"); // linux
		/*try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}  
	
	public int Menu() {
		
		Scanner entrada = new Scanner(System.in);
		int opcao;
		
		do {
			
			clearScreen();
			
			System.out.println(OPCAO_JOGAR + " - Jogar");
			System.out.println(OPCAO_RESULTADOS + " - Resultados");
			System.out.println(OPCAO_SAIR + " - Sair do Programa\n");
			
			opcao = entrada.nextInt();
			
		} while (opcao < OPCAO_JOGAR || opcao > OPCAO_SAIR);
		
		return opcao;
	}
	
	public void Resultados() {
		
		Scanner entrada = new Scanner(System.in);
		String opcao;
		
		clearScreen();
		
		System.out.println("Vitorias do Jogador 1 : " + jogador1Vitorias);
		System.out.println("Vitorias do Jogador 2 : " + jogador2Vitorias);
		System.out.println("Empates : " + empates);
		
		System.out.println("\n\n Pressione <ENTER>");
		
		opcao = entrada.next();
	}
	
	public boolean JogadaValida(int vez, int coordenadaX, int coordenadaY, char [][] tabuleiro) {
		
		boolean retorno = false;
		
		if(tabuleiro[coordenadaX][coordenadaY] == SIMBOLO_VAZIO) {
			retorno = true;
		}
		
		return retorno;
	}
	
	public char FimJogo(char [][]tabuleiro) {
		
		char retorno = SIMBOLO_JOGADOR_1;
		int x,y;
		
		
		if( (tabuleiro[0][0] == SIMBOLO_JOGADOR_1) && 
		    (tabuleiro[1][0] == SIMBOLO_JOGADOR_1) && 
			(tabuleiro[2][0] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => linha 1
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[0][1] == SIMBOLO_JOGADOR_1) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_1) && 
			       (tabuleiro[2][1] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => linha 2
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[0][2] == SIMBOLO_JOGADOR_1) && 
		           (tabuleiro[1][2] == SIMBOLO_JOGADOR_1) && 
			       (tabuleiro[2][2] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => linha 3
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[0][0] == SIMBOLO_JOGADOR_1) && 
		           (tabuleiro[0][1] == SIMBOLO_JOGADOR_1) && 
			       (tabuleiro[0][2] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => coluna 1
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[1][0] == SIMBOLO_JOGADOR_1) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_1) && 
			       (tabuleiro[1][2] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => coluna 2
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[2][0] == SIMBOLO_JOGADOR_1) && 
		           (tabuleiro[2][1] == SIMBOLO_JOGADOR_1) && 
			       (tabuleiro[2][2] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => coluna 3
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[0][0] == SIMBOLO_JOGADOR_1) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_1) && 
			       (tabuleiro[2][2] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => diagonal principal
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[2][0] == SIMBOLO_JOGADOR_1) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_1) && 
			       (tabuleiro[0][2] == SIMBOLO_JOGADOR_1) ) {
				// Verificando se o jogador 1 venceu XXX => diagonal secundaria
				retorno = SIMBOLO_JOGADOR_1;
		} else if( (tabuleiro[0][0] == SIMBOLO_JOGADOR_2) && 
				   (tabuleiro[1][0] == SIMBOLO_JOGADOR_2) && 
				   (tabuleiro[2][0] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 2 venceu XXX => linha 1
				retorno = SIMBOLO_JOGADOR_2;
		} else if( (tabuleiro[0][1] == SIMBOLO_JOGADOR_2) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_2) && 
			       (tabuleiro[2][1] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 1 venceu XXX => linha 2
				retorno = SIMBOLO_JOGADOR_2;
		} else if( (tabuleiro[0][2] == SIMBOLO_JOGADOR_2) && 
		           (tabuleiro[1][2] == SIMBOLO_JOGADOR_2) && 
			       (tabuleiro[2][2] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 2 venceu XXX => linha 3
				retorno = SIMBOLO_JOGADOR_2;
		} else if( (tabuleiro[0][0] == SIMBOLO_JOGADOR_2) && 
		           (tabuleiro[0][1] == SIMBOLO_JOGADOR_2) && 
			       (tabuleiro[0][2] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 2 venceu XXX => coluna 1
				retorno = SIMBOLO_JOGADOR_2;
		} else if( (tabuleiro[1][0] == SIMBOLO_JOGADOR_2) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_2) && 
			       (tabuleiro[1][2] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 2 venceu XXX => coluna 2
				retorno = SIMBOLO_JOGADOR_2;
		} else if( (tabuleiro[2][0] == SIMBOLO_JOGADOR_2) && 
		           (tabuleiro[2][1] == SIMBOLO_JOGADOR_2) && 
			       (tabuleiro[2][2] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 2 venceu XXX => coluna 3
				retorno = SIMBOLO_JOGADOR_2;
		} else if( (tabuleiro[0][0] == SIMBOLO_JOGADOR_2) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_2) && 
			       (tabuleiro[2][2] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 2 venceu XXX => diagonal principal
				retorno = SIMBOLO_JOGADOR_2;
		} else if( (tabuleiro[2][0] == SIMBOLO_JOGADOR_2) && 
		           (tabuleiro[1][1] == SIMBOLO_JOGADOR_2) && 
			       (tabuleiro[0][2] == SIMBOLO_JOGADOR_2) ) {
				// Verificando se o jogador 2 venceu XXX => diagonal secundaria
				retorno = SIMBOLO_JOGADOR_2;
		} else {
			boolean espacoVazioEncontrado = false;
			
			for(x = 0; x < DIMENSAO; ++x) {
				for(y = 0; y < DIMENSAO; ++y) {
					if(tabuleiro[x][y] == SIMBOLO_VAZIO) {
						espacoVazioEncontrado = true;
						break;
					}
				}
				if(espacoVazioEncontrado) {
					break;
				}
			}
			
			if(espacoVazioEncontrado) {
				retorno = SIMBOLO_VAZIO;
			} else {
				retorno = SIMBOLO_EMPATE;
			}
		}
		
		return retorno;
	}
	
	public void ImprimeTabuleiro( char [][]tabuleiro) {
		System.out.println("   1   2   3");
		System.out.println(" |===|===|===|");
		System.out.println("A| " + tabuleiro[0][0] + " | " + tabuleiro[1][0] + " | " + tabuleiro[2][0] + " |");
		System.out.println(" |===|===|===|");
		System.out.println("B| " + tabuleiro[0][1] + " | " + tabuleiro[1][1] + " | " + tabuleiro[2][1] + " |");
		System.out.println(" |===|===|===|");
		System.out.println("C| " + tabuleiro[0][2] + " | " + tabuleiro[1][2] + " | " + tabuleiro[2][2] + " |");
		System.out.println(" |===|===|===|");
	}
	
	public void Jogar() {
		
		Scanner entrada = new Scanner(System.in);
		String opcao;
		Boolean fim;
		String jogador;
		char [][] tabuleiro = new char[DIMENSAO][DIMENSAO];
		int coordenadaX = 0;
		int coordenadaY = 0;
		char resultado = SIMBOLO_VAZIO;
		
		clearScreen();
		
		System.out.println("Jogador 1(" + SIMBOLO_JOGADOR_1 + ") inicia o jogo ?(s/n) ");
		
		opcao = entrada.next();
		
		if( (opcao.equals("s")) || (opcao.equals("S")) ) {
			vez = VEZ_JOGADOR_1;
		} else {
			vez = VEZ_JOGADOR_2;
		}
		
		fim = false;
		
		for(coordenadaX = 0; coordenadaX < DIMENSAO; ++coordenadaX) {
			for(coordenadaY = 0; coordenadaY < DIMENSAO; ++coordenadaY) {
				tabuleiro[coordenadaX][coordenadaY] = SIMBOLO_VAZIO;
			}
		}
		
		
		do {
			
			clearScreen();
			
			if(vez == VEZ_JOGADOR_1) {
				jogador = "1 - " + SIMBOLO_JOGADOR_1;
			} else {
				jogador = "2 - " + SIMBOLO_JOGADOR_2;
			}
			
			System.out.println("Esparando por JOGADOR " + jogador + "\n\n");
			
			ImprimeTabuleiro(tabuleiro);
			
			System.out.println("\n\n");
			
			System.out.println("Entre com a coordenada inicial(A,B,C) : ");
			
			do {
			
				opcao = entrada.next();
				
			} while(!"A".equals(opcao) && !"a".equals(opcao) && 
			        !"B".equals(opcao) && !"b".equals(opcao) && 
					!"C".equals(opcao) && !"c".equals(opcao) );
			
			if(opcao.equals("A") || opcao.equals("a")) {
				coordenadaY = 0;
			} else if(opcao.equals("B") || opcao.equals("b")) {
				coordenadaY = 1;
			} else if(opcao.equals("C") || opcao.equals("c")) {
				coordenadaY = 2;
			}
			
			System.out.println("\n\nEntre com a coordenada final(1,2,3) : ");
			
			do {
			
				opcao = entrada.next();
				
			} while(!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3"));
			
			if(opcao.equals("1")) {
				coordenadaX = 0;
			} else if(opcao.equals("2")) {
				coordenadaX = 1;
			} else if(opcao.equals("3")) {
				coordenadaX = 2;
			}
			
			if(JogadaValida(vez, coordenadaX, coordenadaY, tabuleiro)) {
			
				if(vez == VEZ_JOGADOR_1) {
					tabuleiro[coordenadaX][coordenadaY] = SIMBOLO_JOGADOR_1;
				} else {
					tabuleiro[coordenadaX][coordenadaY] = SIMBOLO_JOGADOR_2;
				}
				
				resultado = FimJogo(tabuleiro);
				
				if(resultado != SIMBOLO_VAZIO) {
					
					System.out.println("\n\n");
					
					ImprimeTabuleiro(tabuleiro);
			
					if(resultado == SIMBOLO_JOGADOR_1) {
						System.out.println("\n\nJogador 1 Venceu!!");
						System.out.println("\nPressione uma tecla e ENTER");
						jogador1Vitorias += 1;
					} else if(resultado == SIMBOLO_JOGADOR_2) {
						System.out.println("\n\nJogador 2 Venceu!!");
						System.out.println("\nPressione uma tecla e ENTER");
						jogador2Vitorias += 1;
				    } else if(resultado == SIMBOLO_EMPATE) {
						System.out.println("\n\nEmpate!!");
						System.out.println("\nPressione uma tecla e ENTER");
						empates += 1;
					}
					
					opcao = entrada.next();
					fim = true;
				
				} else {
					if(vez == VEZ_JOGADOR_1) {
						vez = VEZ_JOGADOR_2;
					} else {
						vez = VEZ_JOGADOR_1;
					}
				}
			} else {
				System.out.println("\n\nJogada Invalida!!");
				System.out.println("\nPressione uma tecla e ENTER");
				opcao = entrada.next();
			}
			
		} while (!fim);
		
	}

}

 // hadjhfaajdh01/10/1986hfjadhfahajh30/11/2017jfhf45/01/2000shfjfadslj

/*
      1        2         3
	|======|==========|==========|
  A	|  X   |   X      |   X      |
	|======|==========|==========|
  B |      |          |          |
	|======|==========|==========|
  C	|      |          |          |
	|======|==========|==========|
	
*/