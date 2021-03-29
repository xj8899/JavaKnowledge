package com.knowledge.moreifelse;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author xj
 * @create Y E A R − {YEAR}-YEAR−{MONTH}-22 10:28 上午
 */
public abstract class Rule {

    public abstract void process();

}

class Rule1 extends Rule{

    @Override
    public void process() {
        System.out.println(1);
    }
}
class Rule2 extends Rule{

    @Override
    public void process() {

    }
}

enum RuleEnum{

    TOUTIAO("",new Rule1()),

    TENCENT("",new Rule2());

    private String name ;

    private Rule rule;

    RuleEnum(String name,Rule rule){
        this.name = name;
        this.rule = rule;
    }


    public static Rule match(String name){
        RuleEnum ruleEnum = valueOf(name);
        return ruleEnum.rule;
    }
}

class Test{



    public static void main(String[] args) {
        String typeName = "TOUTIAO";
        Rule rule  = null;
        Rule match = RuleEnum.match(typeName);
        match.process();
    }
}
