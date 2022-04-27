/**
 *  IFPB
 *  PROF. FAUSTO MARANHAO AYRES
 *
 *  Objetivo:
 *  Ler o arquivo texto "alunos.csv", contendo todos os alunos de uma turma, e 
 *  identificar os alunos aprovados e reprovados de acordo com a suas medias,
 *  gravando-os respectivamente nos arquivos texto 
 *  "aprovados.csv" e "reprovados.csv".
 *  
 *  O arquivo alunos.csv ja esta na pasta deste projeto
 *  
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class LerGravarAlunos{
	public static void main(String[]args) {
		Scanner arquivo1=null;
		try{
			arquivo1 = new Scanner( new File("alunos.csv"));
		}
		catch(FileNotFoundException e){
			System.out.println("arquivo inexistente");
			System.exit(0);
		}

		FileWriter arquivo2 =null;
		FileWriter arquivo3 =null;
		try{
			arquivo2 = new FileWriter( new File("aprovados.csv"), false ); 
			arquivo3 = new FileWriter( new File("reprovados.csv"), false );  
		}
		catch(Exception e){
			System.out.println("problema na cria��o dos arquivos");
			System.exit(0);
		}

		String aluno, cabecalho;	//armazena um aluno lido do arquivo
		String[] partes;			//partes extraidas de um aluno
		String nome, sexo;
		int nota1, nota2;
		long media;

		try {
			cabecalho = arquivo1.nextLine();			//ler e descartar primeira linha do arquivo 
			arquivo2.write("lista de aprovados \n"); 	//grava a primeira linha no arquivo2
			arquivo2.write("nome;media \n"); 			//grava a segunda linha no arquivo2

			arquivo3.write("Lista de reprovados \n"); 	//grava a primeira linha no arquivo3
			arquivo3.write("nome;media \n"); 			//grava a segunda linha no arquivo3

			while(arquivo1.hasNextLine()) {
				aluno = arquivo1.nextLine();			//ler dados de um aluno  
				partes = aluno.split(";");				//extrair os campos do aluno que estao separados por ;
				nome = 	partes[0];						//campo nome 
				nota1 = Integer.parseInt(partes[1]);		//conversao para inteiro
				nota2 = Integer.parseInt(partes[2]);		//conversao para inteiro
				sexo = 	partes[3];						//campo sexo 

				media = Math.round( ((double)nota1+nota2) /2);
				//System.out.println("==> nome:"+nome+"  media:" + media) ;

				//gravar o aluno no arquivo
				if (media >= 70) 	
					arquivo2.write(nome +";" + media +"\n");	//grava a string no arquivo de aprovados
				else 
					arquivo3.write(nome +";" + media +"\n");	//grava a string no arquivo de reprovados

			} //fim do while
			arquivo1.close();			//fechar arquivo
			arquivo2.close();			//fechar arquivo
			arquivo3.close();			//fechar arquivo
		}
		catch(Exception e) {
			System.out.println("houve um problema na grava��o do arquivo");
		}

		System.out.println("ver arquivos gravados na pasta do projeto: aprovados.csv e reprovados.csv");
		System.out.println("fim de programa");
	}    
}