package com.ctci.ch11;

public class MergeSort {
	public static void sort(int[] a) {
		mergesort(a, 0, a.length - 1);
	}

	private static void mergesort(int[] a, int start, int end) {
		if (start >= end) return;
		int mid = (start + end) / 2;
		mergesort(a, start, mid);
		mergesort(a, mid + 1, end);
		merge(a, start, mid, end);
	}

	private static void merge(int[] a, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		int i = 0;
		while (i < n1) {
			left[i] = a[start + i];
			i++;
		}
		int j = 0;
		while (j < n2) {
			right[j] = a[mid + 1 + j];
			j++;
		}
		i = j = 0;
		int k = start;
		while (i < n1 && j < n2) {
			if (left[i] < right[j]) a[k++] = left[i++];
			else a[k++] = right[j++];
		}
		while (i < n1) a[k++] = left[i++];
		while (j < n2) a[k++] = right[j++];
	}
}
