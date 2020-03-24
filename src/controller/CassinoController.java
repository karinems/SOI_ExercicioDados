package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CassinoController extends Thread {

	private String nome;
	private int pontos = 0;
	private Semaphore controle;
	private static int posicao = 0;

	Random numAleatorio = new Random();

	public CassinoController(String nome, Semaphore controle) {
		super();
		this.nome = nome;
		this.controle = controle;
		start();
	}

	@Override
	public void run() {
		jogo();

	}

	private void jogo() {

		int dado1;
		int dado2;

		while (pontos <= 5) {

			dado1 = numAleatorio.nextInt(6) + 1;
			dado2 = numAleatorio.nextInt(6) + 1;

			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if ((dado1 + dado2) == 7 || (dado1 + dado2) == 11) {

				pontos++;
			}

		}

		try {
			controle.acquire();
			imprimeVencedor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			controle.release();
		}

	}

	public void imprimeVencedor() {

		posicao++;

		switch (posicao) {
		case 1:
			System.out.println("Jogador " + this.nome + " ficou em " + posicao + "º" + " lugar => Ganho 5000,00");
			break;
		case 2:
			System.out.println("Jogador " + this.nome + " ficou em " + posicao + "º" + " lugar => Ganho 4000,00");
			break;
		case 3:
			System.out.println("Jogador " + this.nome + " ficou em " + posicao + "º" + " lugar => Ganho 3000,00");
			break;

		default:
			System.out.println("Jogador " + this.nome + " ficou em " + posicao + "º" + " lugar => Não foi seu dia de sorte! TENTE DE NOVO.");
			break;
		}

		System.out.println("");

	}

}
