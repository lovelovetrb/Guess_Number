import java.io.*;

public class Guess_Number{
  public static void main(String[] args) {

    //必要な変数の定義
    int[] answer = {5,2,9};   //答えを配列にて定義
    int[] input = new int[answer.length]; //入力された結果は配列で受け取る
    int round = 1;
    String judg = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String title = "          <<<数字当てゲーム>>>";
    String rule = "　　　　　　　〜ルール〜\n"  // "\n" は改行のためのコード(エスケープシーケンス)
                + "３桁の数字を当てるゲームです。\n"
                + "百の位、十の位、一の位の順で入力をしてください\n"
                + "各位の数字は異なります\n"
                + "最後まで入力すると\n"
                + "・場所も数字もあっている数字の数をhit\n"
                + "・数字だけあっていて場所が違う数字の数をblow\n"
                + "と表示します。\n"
                + "これらの表示をもとに答えの数字を入力してください\n"
                + "※同じ数字を入力した場合、正しいhit,blowの数が表示されない恐れがあります。";
    String begin = "始めるには「start」を入力してください。";

    System.out.println(title);
    System.out.println();
    System.out.println(rule);

    while (!(judg.equals("start"))) { //ゲーム開始のための入力確認
      try{
        System.out.println();
        System.out.println(begin);
        judg = br.readLine();
      } catch (Exception e){  //エラーを検知した場合、もう一度入力を要求する文を表示。
        System.err.println(begin);
      }
    }

    while(judg.equals("start")){  //回答入力処理
      System.out.println();
      System.out.println( "----- ラウンド " + round + " -----" );
      for(int i = 0; i < answer.length ; i++){
         System.out.print( i+1 + "回目の入力です -> ");
         try {
             input[i] = Integer.parseInt(br.readLine()); //次の行の入力を検知して数字の型に変換
         } catch (Exception e) {
             System.err.println("もう一度入力してください");
         }
      }
     //答え判定
     int hit = 0; //変数の初期化
     int blow = 0;

     for(int i = 0; i < answer.length ; i++){//hitの判定処理
         if(input[i] == answer[i]){
           hit++;
          }
      }

      for(int i = 0; i < answer.length ; i++){//blowの判定処理
        for(int j = 0; j < answer.length ; j++){
         if(input[i] == answer[j]){
           blow++;
          }
        }
      }
     //正誤判定
     if(hit == answer.length){
       System.out.println("おめでとうございます！正解は " + answer[0] + answer[1] + answer[2] + " でした！");
       break;
      }

     //入力が正解でなかったときの処理
     System.out.println("hit数" + hit); //hit数、blow数を表示
     System.out.println("blow数" + (blow - hit));
     round ++;
    }
  }
 }
