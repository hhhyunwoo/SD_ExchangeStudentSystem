package Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class selectionManager {
   
   static ArrayList<Float> score = new ArrayList<Float>();
   static ArrayList<Integer> total = new ArrayList<Integer>();
   static ArrayList<Integer> insert = new ArrayList<Integer>();
   static ArrayList<String> univ = new ArrayList<String>();
   static ArrayList<String> www = new ArrayList<String>();
   
   public selectionManager() {
      
   }
   
   public static void selectCandidate() {
      
      try {
         Descend();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      try {
         Volume();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      try {
         Assign();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
   
   //����
   public static void Assign() throws IOException {

      File before = new File("./ApplicationForm");
      File[] befores = before.listFiles();
      System.out.printf("\n�б� ���� ��\n");
      
      for(File go : befores)
      {
         if(go.isFile()) {
             BufferedReader APPDB2 = null;
            File file2 = new File("./ApplicationForm/"+go.getName());
            
            APPDB2 = new BufferedReader(new FileReader(file2));
            
            String data2 = APPDB2.readLine();
            
            String[] array2 = data2.split("@");
            
            System.out.printf("�й�: %s �հݴ���: %s\n", array2[0], array2[8]);
         }
      }
      
      for(int i=0; i<score.size(); i++)
      {
         File folder = new File("./ApplicationForm");
         File[] listOfFiles = folder.listFiles();
         
         for (File file : listOfFiles) {
             if (file.isFile()) {   
                BufferedReader APPDB = null;
               File file2 = new File("./ApplicationForm/"+file.getName());
               
               APPDB = new BufferedReader(new FileReader(file2));               
               int complete = 0;
               
               if(!file.getName().equals(".DS_Store"))
               {
                  String data = APPDB.readLine();
               
                  if(data == null) break; //if not exist variable 'exist' = 0
               
                  String[] array = data.split("@");
                  
                  //FileWriter fw = new FileWriter(file3, true);
               
                  if(score.get(i) == Float.parseFloat(array[7]))
                  {
                     for(int j=0; j<univ.size(); j++) //1���� ����
                     {
                        if(array[4].equalsIgnoreCase(univ.get(j)))
                        {
                           if(insert.get(j) < total.get(j))
                           {
                              insert.set(j, insert.get(j)+1); // �ο� �߰�
                              complete = 1; //���� �Ϸ�
                              data = data.replace("not sorted yet", array[4]);
                              www.add(data);
                              break;
                           }
                        }
                     } 
                     
                     if(complete != 1) //2���� ����
                     {
                        for(int j=0; j<univ.size(); j++)
                        {
                           if(array[5].equalsIgnoreCase(univ.get(j)))
                           {
                              if(insert.get(j) < total.get(j))
                              {
                                 insert.set(j, insert.get(j)+1); // �ο� �߰�
                                 complete = 1; //�����Ϸ�
                                 data = data.replace("not sorted yet", array[5]);
                                 www.add(data);
                                 break;
                              }
                           }
                        }
                     }
                     
                     if(complete != 1) //3���� ����
                     {
                        for(int j=0; j<univ.size(); j++)
                        {
                           if(array[6].equalsIgnoreCase(univ.get(j)))
                           {
                              if(insert.get(j) < total.get(j))
                              {
                                 insert.set(j, insert.get(j)+1); // �ο� �߰�
                                 complete = 1; //�����Ϸ�
                                 data = data.replace("not sorted yet", array[6]);
                                 www.add(data);
                                 break;
                              }
                           }
                        }
                     }
                     
                     if(complete != 1)
                     {
                        data = data.replace("not sorted yet","���հ�");
                        www.add(data);
                     }
                     complete = 0; //�Ϸ� �ʱ�ȭ   
                  }
               }
               APPDB.close();
             }
         }
      }
      
      //���� ���� ����
      File file = new File("./ApplicationForm");
        File[] files = file.listFiles();
        
        for( int i=0; i<files.length; i++)
           files[i].delete();
        
        System.out.printf("\n�б� ���� ��\n");
        //������Ʈ�� ������ ���� �ٽ� ����
        for(int i=0; i<www.size(); i++)
        {
           String arr[] = www.get(i).split("@");
            File file3 = new File("./ApplicationForm/" + arr[0] + ".txt");
             
            // true ������ ������ ���� ���뿡 �̾ �ۼ�
            FileWriter fw = new FileWriter(file3);
             
            // ���Ͼȿ� ���ڿ� ����
            fw.write(www.get(i));
            fw.flush();
 
            // ��ü �ݱ�
            fw.close();
            System.out.printf("�й�: %s �հݴ���: %s\n", arr[0], arr[8]);
        }
           
        System.out.printf("\n");
   }
   
   
   //������ �̾� �������� ����
   public static void Descend() throws IOException {

      
      /*
      BufferedReader APPDB2 = null;
      File file2 = new File("ApplicationInfo.txt");
      
      APPDB2 = new BufferedReader(new FileReader(file2));
      
      while(true)
      {
         String data2 = APPDB2.readLine();
         
         if(data2 == null) break;
         
         String[] array2 = data2.split("@"); 
         
         score.add(Float.parseFloat(array2[7]));
      }
      */
      
      File folder = new File("./ApplicationForm");
      File[] listOfFiles = folder.listFiles();

      for (File file : listOfFiles) {
          if (file.isFile()) {         
            BufferedReader APPDB2 = null;
            
            File file2 = new File("./ApplicationForm/" + file.getName());
            
            if(!file.getName().equals(".DS_Store")) {
            APPDB2 = new BufferedReader(new FileReader(file2));
            
            String data2 = APPDB2.readLine();
               
            if(data2 == null) break;
               
            String[] array2 = data2.split("@"); 
               
            score.add(Float.parseFloat(array2[7]));
            }
          }
      }
      
      //reverse sorting
      Collections.sort(score);
      Collections.reverse(score);
   }
   
   //������ �����ο�, �����ο� 
   public static void Volume() throws IOException {
      
      BufferedReader APPDB3 = null;
      File file3 = new File("DUInfo.txt");
      
      APPDB3 = new BufferedReader(new FileReader(file3));
      
      while(true)
      {
         String data3 = APPDB3.readLine();
         
         if(data3 == null) break;
         
         String[] array3 = data3.split("@");
         
         total.add(Integer.parseInt(array3[6]));
         univ.add(array3[5]);
         insert.add(0); //�����ο� �迭
      }
      APPDB3.close();
   }
   
   public static void Adjust() throws IOException {
      
      System.out.print("\n�����Ͻ� �л��� �й��� �Է��ϼ���: ");
      String Ad;
      Scanner sc = new Scanner(System.in);
      
      Ad = sc.nextLine();
      
      File list = new File("./ApplicationForm");
      File[] lists = list.listFiles();
      
      String[] array3 = null;
      for(File go : lists)
      {
         if(go.isFile()) {
             BufferedReader APPDB3 = null;
            File file3 = new File("./ApplicationForm/"+go.getName());
            
            APPDB3 = new BufferedReader(new FileReader(file3));
            
            String data3 = APPDB3.readLine();
            
            array3 = data3.split("@");
            
            if(Ad.equalsIgnoreCase(array3[0]))
            {
               System.out.printf("���� ����: %s\n", array3[8]);
               System.out.print("������ �����Է�: ");
               String newuniv = sc.nextLine();
               
               array3[8] = newuniv;
               APPDB3.close();
               break;
            }
         }
      }
      
      String sample = "";
      for(int i=0; i<9; i++) {
         if(i!=8)
            sample += array3[i] + "@";
         else
            sample += array3[i];
      }
      
      //���� ���� ����
        File file3 = new File("./ApplicationForm/" + array3[0] + ".txt");       
        FileWriter fw = new FileWriter(file3);       
        fw.write(sample);
        fw.flush();
        fw.close();
        
        //���� ���
        File out = new File("./ApplicationForm");
        File[] outs = out.listFiles();
        
        for(File go : outs)
        {
           if(go.isFile()) {
               BufferedReader APPDB2 = null;
              File file2 = new File("./ApplicationForm/"+go.getName());
              
              APPDB2 = new BufferedReader(new FileReader(file2));
              
              String data2 = APPDB2.readLine();
              
              String[] array2 = data2.split("@");
              
              System.out.printf("�й�: %s �հݴ���: %s\n", array2[0], array2[8]);
           }
        }
        
        System.out.printf("\n");
        
        
      
   }
   

}