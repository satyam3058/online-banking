package com.onlinebanking.springrest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringrestApplicationTests {

	@Test
	void contextLoads() {
	}

}
import pandas as pd

# Load the CSV files
df1 = pd.read_csv('file1.csv')
df2 = pd.read_csv('file2.csv')

# Ensure both DataFrames have the same structure
common_columns = df1.columns.intersection(df2.columns)
df1 = df1[common_columns]
df2 = df2[common_columns]

# Sort both DataFrames by key columns (adjust these as needed)
compare_columns = ['PGROSS', 'MTRACE']
df1_sorted = df1.sort_values(by=compare_columns).reset_index(drop=True)
df2_sorted = df2.sort_values(by=compare_columns).reset_index(drop=True)

# Find all rows that differ
differences_mask = (df1_sorted != df2_sorted) & ~(df1_sorted.isnull() & df2_sorted.isnull())

# Filter only the differing rows
diff_rows = differences_mask.any(axis=1)
df1_diff = df1_sorted[diff_rows].copy()
df2_diff = df2_sorted[diff_rows].copy()

# Add prefixes to distinguish sources
df1_diff.columns = [f'{col}_file1' for col in df1_diff.columns]
df2_diff.columns = [f'{col}_file2' for col in df2_diff.columns]

# Combine side-by-side
diff_combined = pd.concat([df1_diff, df2_diff], axis=1)

# Export to CSV
diff_combined.to_csv('side_by_side_diff.csv', index=False)
print("Side-by-side differences saved to 'side_by_side_diff.csv'")
