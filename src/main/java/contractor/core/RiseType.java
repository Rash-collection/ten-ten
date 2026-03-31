/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contractor.core;

/**
 * <p>Rise type is based on height as in it's floors number.</p>
 * @author rash4
 */
public enum RiseType {
    Low(4),
    Mid(9),
    High(19),
    Skyscraper(99),
    ;
    RiseType(int max){
        this.MAX = max;
    }
    public static RiseType classify(int levels){
        if(levels < 1 || levels > Skyscraper.MAX)
            throw new IllegalArgumentException("no levels = no rise -_-");
        else if(levels <= Low.MAX)return Low;
        else if(levels <= Mid.MAX)return Mid;
        else if(levels <= High.MAX)return High;
        else return Skyscraper;
    }
    
    public boolean isLow (){return this == Low;}
    public boolean isMid (){return this == Mid;}
    public boolean isHigh(){return this == High;}
    public boolean isSkys(){return this == Skyscraper;}
    
    public int maxLevels (){return this.MAX;}
    final int MAX;
}