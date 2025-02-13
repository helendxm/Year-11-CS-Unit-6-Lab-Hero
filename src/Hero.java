public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name)
    {
        this.name = name;
        hitPoints = 100;
    }

    public String getName()
    {
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent){
        double random = Math.random();
        if (random < 0.5) {
            opponent.hitPoints = opponent.hitPoints - 10;
        }
        else{
            this.hitPoints = this.hitPoints - 10;
        }
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while (opponent.hitPoints > 0 && this.hitPoints > 0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        this.senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return this.name + ": " + this.hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] fightsWon = new int[2];
        for (int i = 0; i < n; i++){
            fightUntilTheDeathHelper(opponent);
            if (hitPoints > 0){
                fightsWon[0]++;
            }
            else {
                fightsWon[1]++;
            }
        }
        return fightsWon;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        String winMessage;
        int[] results = nFightsToTheDeathHelper(opponent, n);
        if (results[0] > results[1])
        {
            winMessage = name + " wins!";
        }
        else if (results[1] > results[0])
        {
            winMessage = opponent.getName() + " wins!";
        }
        else
        {
            winMessage = "OMG! It was actually a draw!";
        }
        return name + ": " + results[0] + " wins" + "\n" + opponent.getName() + ": " + results[1] + " wins" + "\n" + winMessage;
    }

    public void dramaticFightToTheDeath(Hero opponent){
        String winningHero = "";
        senzuBean();
        opponent.senzuBean();
        while (hitPoints > 0 && opponent.hitPoints > 0)
        {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
            if (hitPoints == 0)
            {
                winningHero = opponent.getName();
            }
            else if (opponent.getHitPoints() == 0)
            {
                winningHero = name;
            }
        }
        System.out.println(winningHero + " wins!");
    }
}
