import java.util.*;


public class Test{


  public static String [] method = {"+","-","*","��"};

  public static void main(String []args){
  try{
      System.out.println("len is "+args.length);
      if(args == null || args.length !=5 ) {
                System.out.println("������4����������һ����Ҫ���ҵĽ����������");
                System.exit(0);
      }
      Integer a[] = new Integer[args.length-1];
      for(int i=0;i<args.length-1;i++){
            a[i] = Integer.parseInt(args[i]);
     }
     Integer target = Integer.parseInt(args[args.length-1]);
      printArr(a);
      System.out.println("Ŀ��������Ϊ��"+target);
     

     // �����������
        Solution<Integer> sol = new Solution<Integer>(false);

      List<List<Integer>> resultList = sol.permute(a);
      for(int i=0;i<resultList.size();i++){               
           //  System.out.println(i+"    ******   "+resultList.get(i));
           
       }


     // ��������������˳�� ����ֶ������һ�������������
     Solution<String> sol2 = new Solution<String>(true);
      List<List<String>> resultList2 = sol2.permute(method);
      for(int i=0;i<resultList2.size();i++){
               
            // System.out.println(i+"    ******   "+resultList2.get(i));
            
       }

calRes(resultList,resultList2,target);

/**
     for(int i=0;i<resultList.size();i++){
         for(int j=0;j<resultList2.size();j++){
             List<Integer> numList = resultList.get(i);
             List<String> method = resultList2.get(j);
              String calStr = new String("");
              for(int m=0;m<numList.size();m++){
                 calStr += numList.get(m);
                 if(m != method.size()-1){
                 calStr += method.get(m);
                   }
             }
             System.out.println("��ʽΪ��"+calStr);
          }
     }
*/

        }catch(Exception e){
          e.printStackTrace();
     }

  }


/**
*   A?B?C?D
*   (A?B)
*
*/
  private static void calRes(List<List<Integer>>  resultList,List<List<String>> resultList2,Integer target){
       
     for(int i=0;i<resultList.size();i++){
         for(int j=0;j<resultList2.size();j++){
             List<Integer> numList = resultList.get(i);
             List<String> method = resultList2.get(j);
              String calStr = new String("");
               int totalResult = 0;
              boolean right = true;
              for(int m=0;m<numList.size();m++){
                 calStr += numList.get(m);
                 if(m != method.size()-1){
                   String oper = method.get(m);
                   calStr += oper;
                   
                   int numLast = m==0 ?numList.get(m):totalResult;
                   int numNext = numList.get(m+1);
                   if("+".equals(oper)){
                      totalResult = numLast + numNext;
                   }else if("-".equals(oper)){
                      totalResult = numLast - numNext;
                      if(totalResult <0 ){
                        right = false;
                      }
                   }else if("*".equals(oper)){
                      totalResult = numLast * numNext;
                   }else if("��".equals(oper)){
                      totalResult = numLast / numNext;
                       //����ǳ���������Ϊ0�������
                      if(numLast % numNext >0 ){
                        right = false;
                      }
                   }   
                 } 
                             
             }
              if(right ){
                  //System.out.println("��ʽΪ��"+calStr+" = " + totalResult);
              }
              if(target.equals(totalResult)){
                    System.out.println("��ʽΪ��"+calStr+" = " + totalResult);
               }         
          }
     }

 }

  private static void printArr(Integer []a){
    System.out.println();
    System.out.print("���������Ϊ");
    for(int i=0;i<a.length;i++){
         System.out.print(a[i]);
    }
    System.out.println();
  }
}		