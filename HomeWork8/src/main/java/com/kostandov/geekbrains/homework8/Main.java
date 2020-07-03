package com.kostandov.geekbrains.homework8;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    //Task 1
    public static String hundredWords(String text){
        return Arrays.stream(text.
                replaceAll("[^а-яА-Я\\s]", "").
                split(" ")).
                filter(s->s.length()>5).
                collect(Collectors.joining(" "));
    }

    //Task 2
    public static List<String> uniqueWordsOfMatrix(String[][] matrix){
        return Arrays.stream(matrix).
                flatMap(Arrays::stream).
                distinct().
                collect(Collectors.toList());
    }

    //Task 3
    public static int sumStartingFromHundred(){
        return Stream.iterate(100,n->n+2).limit(51).mapToInt(n->n).sum();
    }

    //Task 4
    public static int sumOfLength(String[] lines){
       return Arrays.stream(lines).map(line->line.split(" "))
               .flatMap(Arrays::stream)
               .mapToInt(s->s.length()).sum();

    }

    //Task 5
    public static String firstThreeWords(String[] words){
        return Arrays.stream(words).
                map(s->s.toLowerCase()).
                sorted().
                limit(3).
                collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {

        String text="Они дошли до площади Звезды. Ее лучистые контуры огромной снежинки тонули сейчас в моросящей " +
                "завесе и казались нескончаемыми. Туман сгустился, и улиц, что разбегаются от площади лучами, было не " +
                "видно. Перед ними раскинулась только сама площадь, широченная, с разбросанными тут и там тусклыми лунами " +
                "фонарей и мощной каменной аркой посередине, чья громада, пропадая в мглистой дымке, казалось, подпирает собой" +
                " насупленное небо, укрывая исполинскими сводами сиротливое, бледное и трепетное пламя на могиле неизвестного" +
                " солдата, словно это последняя могила рода человеческого, затерянная среди безлюдья вечной ночи.\n" +
                "Они пошли через площадь напрямик. Равич шел быстро. Больно уж он измотан, чтобы еще и думать. Подле " +
                "себя он слышал усталые, неуверенные шаги женщины, что молча следовала за ним, понурив голову, пряча" +
                " руки в карманах плаща, – еще один трепетный, беззащитный огонек чьей-то жизни, о которой он ничего не" +
                " знает, но которая именно сейчас, внезапно, посреди ночной пустынной площади показалось ему странно " +
                "близкой,почти родной.";

        Random random=new Random();
        String[][] matrix=new String[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                matrix[i][j]=random.nextInt(15)+"";
            }
        }

        String[] lines=("Они дошли до площади Звезды, Ее лучистые контуры огромной снежинки тонули сейчас в моросящей " +
                "завесе и казались нескончаемыми").split(",");
        String[] words=("Ее лучистые контуры огромной снежинки тонули сейчас в моросящей " +
                "завесе и казались нескончаемыми").split(" ");

        System.out.println(hundredWords(text));
        System.out.println(uniqueWordsOfMatrix(matrix));
        System.out.println(sumStartingFromHundred());
        System.out.println(sumOfLength(lines));
        System.out.println(firstThreeWords(words));

    }
}
