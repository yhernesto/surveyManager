/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorClasses;

/**
 *
 * @author ernesto
 */
public class NumericalAnswers extends Answers{
    private Float mean;
    private Float meanError;
    private Float variance;
    private Float median;
    
    
    public NumericalAnswers(){
        super();
        this.mean       = null;
        this.meanError  = null;
        this.median     = null;
        this.variance   = null;
    }

    public Float getMean() {
        return mean;
    }

    public void setMean(Float mean) {
        this.mean = mean;
    }

    public Float getMeanError() {
        return meanError;
    }

    public void setMeanError(Float meanError) {
        this.meanError = meanError;
    }

    public Float getVariance() {
        return variance;
    }

    public void setVariance(Float variance) {
        this.variance = variance;
    }

    public Float getMedian() {
        return median;
    }

    public void setMedian(Float median) {
        this.median = median;
    }

    @Override
    public String toString() {
        return "NumericalAnswers{" + "size:" + super.getAnswers().size() + ", mean=" + mean + ", meanError=" + meanError + ", variance=" + variance + ", median=" + median + '}';
    }
    
}
