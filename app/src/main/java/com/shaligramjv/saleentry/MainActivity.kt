package com.shaligramjv.saleentry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SaleRow(
    val vehicleNo: String = "",
    val serialNo: String = "",
    val date: String = "",
    val indentNo: String = "",
    val name: String = "",
    val caseValue: String = "",
    val pcs: String = "",
    val checked: Boolean = false
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SaleEntryApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaleEntryApp() {

    var rows by remember {
        mutableStateOf(listOf(SaleRow()))
    }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "SHALIGRAM JV – SALE ENTRY",
                            fontSize = 20.sp
                        )
                    }
                )
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {

                Button(
                    onClick = {
                        // Scan Indent functionality will be added later
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("SCAN INDENT")
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    itemsIndexed(rows) { index, row ->

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Column(
                                modifier = Modifier.padding(12.dp)
                            ) {

                                Text(
                                    text = "Row ${index + 1}",
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                OutlinedTextField(
                                    value = row.vehicleNo,
                                    onValueChange = { value ->
                                        rows = rows.toMutableList().also {
                                            it[index] = row.copy(vehicleNo = value)
                                        }
                                    },
                                    label = { Text("Vehicle No.") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                OutlinedTextField(
                                    value = row.serialNo,
                                    onValueChange = { value ->
                                        rows = rows.toMutableList().also {
                                            it[index] = row.copy(serialNo = value)
                                        }
                                    },
                                    label = { Text("S.No.") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                OutlinedTextField(
                                    value = row.date,
                                    onValueChange = { value ->
                                        rows = rows.toMutableList().also {
                                            it[index] = row.copy(date = value)
                                        }
                                    },
                                    label = { Text("Date") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                OutlinedTextField(
                                    value = row.indentNo,
                                    onValueChange = { value ->
                                        rows = rows.toMutableList().also {
                                            it[index] = row.copy(indentNo = value)
                                        }
                                    },
                                    label = { Text("Indent No.") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                OutlinedTextField(
                                    value = row.name,
                                    onValueChange = { value ->
                                        rows = rows.toMutableList().also {
                                            it[index] = row.copy(name = value)
                                        }
                                    },
                                    label = { Text("Name") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                OutlinedTextField(
                                    value = row.caseValue,
                                    onValueChange = { value ->
                                        rows = rows.toMutableList().also {
                                            it[index] = row.copy(caseValue = value)
                                        }
                                    },
                                    label = { Text("Case") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                OutlinedTextField(
                                    value = row.pcs,
                                    onValueChange = { value ->
                                        rows = rows.toMutableList().also {
                                            it[index] = row.copy(pcs = value)
                                        }
                                    },
                                    label = { Text("Pcs") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = row.checked,
                                        onCheckedChange = { checked ->
                                            rows = rows.toMutableList().also {
                                                it[index] = row.copy(checked = checked)
                                            }
                                        }
                                    )

                                    Text("✓")
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    OutlinedButton(
                        onClick = {
                            rows = rows + SaleRow()
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("+ ADD ROW")
                    }

                    Button(
                        onClick = {
                            // Save functionality will be added later
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("SAVE ENTRY")
                    }
                }
            }
        }
    }
}
