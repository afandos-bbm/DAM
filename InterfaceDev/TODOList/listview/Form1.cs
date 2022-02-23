using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace listview
{
    public partial class Form1 : Form
    {
        public string[] array { get; private set; }

        public Form1()
        {
            InitializeComponent();
            loadXML();
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

        private void saveData()
        {
            using (StreamWriter file = File.CreateText(Path.GetFullPath(".") + "\\todolistdata.xml"))
            {
                listView1.Items.CopyTo(array,0);
                XDocument doc = new XDocument();
                foreach (var item in array)
                {
                doc.Add(new XElement("tarea", item.Select(x => new XElement(x.ToString(),x))));
                }
            }
        }

        public void loadXML()
        {
            listView1.Columns.Add("Description");
            listView1.Columns.Add("Start Date");
            listView1.Columns.Add("End Date");
            if (!File.Exists(Path.GetFullPath(".\\todolistdata.xml")))
            {
                Console.WriteLine(Path.GetFullPath(".\\todolistdata.xml"));
                using (FileStream fs = File.Create(Path.GetFullPath(".\\todolistdata.xml")));
                XDocument initDoc = XDocument.Load(Path.GetFullPath(".") + "\\todolistdata.xml");
                initDoc.Add(new XElement("root"));
                initDoc.Save(Path.GetFullPath(".\\todolistdata.xml"));

            }
            XDocument doc = XDocument.Load(Path.GetFullPath(".") + "\\todolistdata.xml");

            foreach (var dm in doc.Descendants("pedidos"))
            {
                ListViewItem item = new ListViewItem(new String[]
                {
                    dm.Element(textBox1.Text).Value,
                    dm.Element(dateTimePicker1.Value.ToString()).Value,
                    dm.Element(dateTimePicker2.Value.ToString()).Value,
                });
                listView1.Items.Add(item);
            }
        }
    }
}