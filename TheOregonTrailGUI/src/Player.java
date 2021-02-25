public class Player
	{
		String job;
		double money;
		int health;
		int food;
		int water;
		
		public static final int STARTING_HEALTH = 100;
		
		public Player(String j, double m, int h, int f, int w)
		{
			job=j;
			money=m;
			health=h;
			food=f;
			water=w;
		}

		public String getJob()
			{
				return job;
			}

		public void setJob(String job)
			{
				this.job = job;
			}

		public double getMoney()
			{
				return money;
			}

		public void setMoney(double money)
			{
				this.money = money;
			}

		public int getHealth()
			{
				return health;
			}

		public void setHealth(int health)
			{
				this.health = health;
			}

		public int getFood()
			{
				return food;
			}

		public void setFood(int food)
			{
				this.food = food;
			}


		
	}

