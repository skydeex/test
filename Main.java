import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] A = {5, 2, 4, 6, 1, 3, 2, 6};
		sort(A,1, A.length);

		System.out.println(
				Arrays.toString(A)
		);

	}

	// алгоритм sort весьма лаконичен :)
	static void sort(int[] A, int p, int r) {
		if(p < r) {
			int q = (p + r) >> 1;

			sort(A, p, q);
			sort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}


	static void merge(int[] A, int p, int q, int r) {

		// Автор, ты иммел ввиду порядковые номера или индекс массива с длинной?
		// A.length подсказывает на номер, поэтому ниже p--; q--; r--;
		p--; q--; r--;



		if(A[q] > A[q + 1]) {
			int qVal;

			// меняем местами половины
			if(A[p] >= A[r]) {
				p--;

				while (q > p) {
					qVal = A[q];

					A[q--] = A[r];
					A[r--] = qVal;
				}

			} else { // иначе крутим

				while (true) {
					if(q < p)
						break;

					if(A[q] < A[r]) { // ищем стартовый индекс справо-налево в правой половине
						r--;

					} else { // найдя который перемещаем значения
						qVal = A[q];
						for(int i = q; i < r; i++)
							A[i] = A[i + 1];
						A[r] = qVal;

						r--;
						q--;
					}
				}
			}

		}

	}


}



