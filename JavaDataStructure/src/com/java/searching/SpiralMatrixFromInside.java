package com.java.searching;

public class SpiralMatrixFromInside {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[][] = {
				{21,22,23,24,25},
				{20,7,8,9,10},
				{19,6,1,2,11},
				{18,5,4,3,12},
				{17,16,15,14,13}
		};

		sprialFromInside(a);
	}

	static void sprialFromInside(int a[][]) {

		int rs = 0, cs = 0;
		int re = a.length, ce = a[0].length;
		int rms = re/2, rme = re/2;
		int cms = ce/2, cme = ce/2;
		int i;

		while(rme < re && cme < ce) {

			for(i = cms; i<=cme; i++) {
				System.out.print("  " + a[rms][i]);
			}
			cme++;
			rme++;

			if(rme<re && rms >= rs) {
				for(i=rms;i<=rme;i++) {
					System.out.print("  " + a[i][cme]);
				}
				cms--;
			}

			if(rme<re && rms >= rs) {
				for(i=cme-1;i>=cms;i--) {
					System.out.print("  " + a[rme][i]);
				}
				rms--;
			}

			if(cme<ce && cms >= cs) {
				for(i=rme-1;i>rms;i--) {
					System.out.print("  " + a[i][cms]);
				}
			}



		}
	}
}
