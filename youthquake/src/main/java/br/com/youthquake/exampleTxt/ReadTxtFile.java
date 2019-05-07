package br.com.youthquake.exampleTxt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ReadTxtFile {
	public static void main( String[] args )
	   {
	       Scanner input= null;

	       try
	       {
	          input = new Scanner(new FileReader("goal.txt")).useDelimiter(";|\\r\\n");
	       }
	       catch ( FileNotFoundException fileNotFoundException )
	       {
	          System.err.println( "Erro ao abrir arquivo." );
	          System.exit( 1 );
	       }

	       GoalTxt goal= new GoalTxt(0, null, null, null, null, 0, 0, 0);
	       
	       System.out.printf( "%-10s%-25s%-30s%-15s%-15s%-10s%-20s%-10s\n", "Goal ID","Name","Description","Start Date","End Date", "Value", "Value Accumulated", "Percentage" );
	       
	       try 
	       {
	          while ( input.hasNext() )
	          {
	              goal.setIdGoal(input.nextInt()); 
	        	  goal.setName(input.next()); 
	              goal.setDescription(input.next());
	              goal.setDtStart(input.next()); 
	              goal.setDtEnd(input.next()); 
	              goal.setValue(input.nextInt());
	              goal.setValueAccumulated(input.nextInt());
	              goal.setPercentage(input.nextInt());
	             
	              
	        	  System.out.printf("%-10s%-25s%-30s%-15s%-15s%-10s%-20s%-10s\n", goal.getIdGoal(), goal.getName(), goal.getDescription(), goal.getDtStart(),
	        			  goal.getDtEnd(), goal.getValue(), goal.getValueAccumulated(), goal.getPercentage() );
	          }
	       }
	       catch ( NoSuchElementException elementException )
	       {
	           System.err.println( "Arquivo com problemas." );
	           input.close();
	           System.exit( 1 );
	       }
	       catch ( IllegalStateException stateException )
	       {
	           System.err.println( "Erro na leitura do arquivo." );
	           System.exit( 1 );
	       }
	 
	       /* Fecha o arquivo */
	       if ( input != null )
	           input.close();
	   
	   }
}
