/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import GeneratorClasses.Answers;
import InterfaceClasses.QuestionType;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ernesto
 */
public class MathUtils {
    
    public MathUtils(){
        
    }
    
    static public Float getMean(ArrayList list){
        Float average = null;
        int sum = 0;
        for(Object value : list) sum = sum + (int) value;
        average = list.isEmpty() ? Float.valueOf(0) : Float.valueOf((float) sum/list.size());
        return average;
    }

    static public Float getMedian(ArrayList list){
        int med_0, med_1;
        Float median = null;
        if(list != null && !list.isEmpty()){
            Collections.sort(list);
            if(list.size() % 2 == 0){
                med_0 = (int) list.get((list.size()/2)-1);
                med_1 = (int) list.get(list.size()/2);
                median = Float.valueOf((float) ((med_0 + med_1)/2));
            }else{
                int med = (int) list.get((int) list.size() / 2);
                median = Float.valueOf((float) med);
            }
        }else{
            median = Float.valueOf(0);
        }
        return median;
    }
    
    static public Float getVariance(ArrayList list, Float media){
        Float variance = null;
        int intValue;
        float sum=0, floatValue;
        if(list != null && media != null){
            for(Object value: list){
                if(value != null){
                    intValue = (int) value;
                    floatValue = (float) intValue;
                    sum = sum + (floatValue-media)*(floatValue-media);
                }
            }
            variance = list.isEmpty() ? Float.valueOf(0) : (float) sum/list.size();
            variance = (float) (Math.rint(variance*100)/100);     
        }
        return variance;
    }
    
    
    static public Float getMeanError(ArrayList list, Float variance, Integer studentsEnrolled){
        Float meanError = null;
        if(variance != null && variance != null && studentsEnrolled != null && studentsEnrolled > 0){
            if(!list.isEmpty()){
                float numerador = (float)(1.96*1.96)*((variance*variance)*(studentsEnrolled - list.size()));
                float denominador = (list.size() * (studentsEnrolled-1));
                meanError = (float) sqrt(numerador/denominador);
            }
        }
        return meanError; 
    }
    
    static public Integer columnNameToInteger(String str){
        char c = str.charAt(0);
        int intChar, nextIntChar=0;
        intChar = Character.digit(c, 36)-10;
        if(str.length()>1){
            nextIntChar = columnNameToInteger(str.substring(1));
            intChar = intChar * 26;
        }
        intChar = intChar + nextIntChar;
        return intChar;
    }
}
