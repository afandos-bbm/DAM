using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace listview
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ListViewItem lista = new ListViewItem(textBox1.Text);
            lista.SubItems.Add(dateTimePicker1.Text);
            lista.SubItems.Add(dateTimePicker1.Text);
            listView1.Items.Add(lista);
        }           

        private void button2_Click(object sender, EventArgs e)
        {
            foreach (ListViewItem listViewItem in listView1.SelectedItems)
            {
                listViewItem.Remove();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();
        }
    }
}
