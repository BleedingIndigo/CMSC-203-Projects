
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.Color;

public class BarChart implements ImageObserver
{
    public static final int XMAX = 400;
    public static final int XSTART = 60;
    public static final int[] YMAX = {220, 320, 420, 520};

    private Color[] colors = {
        Color.BLUE,
        new Color(150, 150, 0),
        Color.DARK_GRAY,
        Color.MAGENTA
    };

    private int[][] data;
    private int barSize;
    private int xStart;
    private int activity = 5;
    private int studentResult;
    private int exactFrequencyCount;
    private int exactMinimum;
    private int key;
    private boolean checkNewValues;

    public BarChart()
    {
    }

    public BarChart(int[][] dArray)
    {
        data = new int[dArray.length][dArray[0].length];

        for (int i = 0; i < dArray.length; i++)
        {
            for (int j = 0; j < dArray[i].length; j++)
            {
                data[i][j] = dArray[i][j];
            }
        }

        barSize = (XMAX - 20) / data[0].length;
        studentResult = -1;
        exactFrequencyCount = -1;
        exactMinimum = -1;
        key = -1;
        checkNewValues = true;
    }

    public void setArray(int[][] dArray)
    {
        for (int i = 0; i < dArray.length; i++)
        {
            for (int j = 0; j < dArray[i].length; j++)
            {
                data[i][j] = dArray[i][j];
            }
        }
    }

    public void setStudentResult(int result)
    {
        studentResult = result;
    }

    public void setKey(int newKey)
    {
        key = newKey;
    }

    public int getExactFrequencyCount()
    {
        return exactFrequencyCount;
    }

    public int getExactMinimum()
    {
        return exactMinimum;
    }

    public boolean getCheckNewValues()
    {
        return checkNewValues;
    }

    public void setActivity(int a)
    {
        activity = a;
    }

    public int getActivity()
    {
        return activity;
    }

    public void updateBarChart(int key, int index1, int index2, Graphics g)
    {
        draw(g);

        switch (activity)
        {
            case 1:
                drawArray(index1, index2, g);
                break;

            case 2:
                drawNewValue(index1, index2, g);
                break;

            case 3:
                drawMinimum(index1, index2, g);
                break;

            case 4:
                drawFrequency(index1, index2, key, g);
                break;
        }
    }

    public void draw(Graphics g)
    {
        if (data == null)
            return;

        for (int i = 0; i < data.length; i++)
        {
            xStart = XSTART;
            g.setColor(colors[i]);

            for (int j = 0; j < data[i].length; j++)
            {
                g.fillRect(xStart, YMAX[i] - data[i][j],
                    barSize - 5, data[i][j]);

                g.drawString("" + data[i][j],
                    xStart, YMAX[i] + 15);

                xStart += barSize;
            }
        }
    }

    public void drawArray(int index1, int index2, Graphics g)
    {
        g.setColor(Color.RED);

        for (int i = 0; i < index1; i++)
        {
            xStart = XSTART;

            for (int j = 0; j < data[i].length; j++)
            {
                g.fillRect(xStart, YMAX[i] - data[i][j],
                    barSize - 5, data[i][j]);

                xStart += barSize;
            }
        }

        xStart = XSTART;

        for (int j = 0; j <= index2; j++)
        {
            g.fillRect(xStart, YMAX[index1] - data[index1][j],
                barSize - 5, data[index1][j]);

            xStart += barSize;
        }
    }

    public void drawNewValue(int index1, int index2, Graphics g)
    {
        g.setColor(Color.BLUE);

        checkCurrentNewValues(index1, index2);

        String s = checkNewValues ? "correctly" : "incorrectly";

        g.drawString("Setting row " + index1 + " to " + key, 25, 110);
        g.drawString("Values are set " + s, 25, 130);

        g.setColor(Color.RED);
        xStart = XSTART;

        for (int j = 0; j <= index2; j++)
        {
            g.fillRect(xStart, YMAX[index1] - data[index1][j],
                barSize - 5, data[index1][j]);

            xStart += barSize;
        }
    }

    private void checkCurrentNewValues(int index1, int index2)
    {
        checkNewValues = true;

        for (int j = 0; j <= index2; j++)
        {
            if (data[index1][j] != key)
            {
                checkNewValues = false;
                break;
            }
        }
    }

    public void drawMinimum(int index1, int index2, Graphics g)
    {
        if (index1 < 0 || index2 < 0)
            return;

        int minimum = findSubMinimum(index1, index2);

        g.setColor(Color.BLUE);
        g.drawString("Your minimum: " + studentResult, 25, 110);

        exactMinimum = findSubMinimum(3, index2);

        g.drawString("Correct minimum: " + exactMinimum, 25, 130);

        g.setColor(Color.RED);

        xStart = XSTART + index2 * barSize;

        g.drawRect(xStart, YMAX[index1] - data[index1][index2],
            barSize - 5, data[index1][index2]);

        for (int i = 0; i <= index1; i++)
        {
            if (data[i][index2] == minimum)
            {
                g.fillRect(xStart, YMAX[i] - data[i][index2],
                    barSize - 5, data[i][index2]);
                break;
            }
        }
    }

    public int findSubMinimum(int index1, int index2)
    {
        int minimum = data[0][index2];

        for (int i = 1; i <= index1; i++)
        {
            if (minimum > data[i][index2])
            {
                minimum = data[i][index2];
            }
        }

        return minimum;
    }

    public void drawFrequency(int index1, int index2, int value, Graphics g)
    {
        g.setColor(Color.BLUE);

        g.drawString("Your frequency: " + studentResult, 25, 110);

        exactFrequencyCount = findExactFrequencyCount(index1, index2, value);

        g.drawString("Correct frequency: " + exactFrequencyCount,
            25, 130);

        g.setColor(Color.RED);

        for (int i = 0; i < index1; i++)
        {
            xStart = XSTART;

            for (int j = 0; j < data[i].length; j++)
            {
                if (data[i][j] == value)
                {
                    g.fillRect(xStart, YMAX[i] - data[i][j],
                        barSize - 5, data[i][j]);
                }

                xStart += barSize;
            }
        }

        xStart = XSTART;

        for (int j = 0; j <= index2; j++)
        {
            if (data[index1][j] == value)
            {
                g.fillRect(xStart, YMAX[index1] - data[index1][j],
                    barSize - 5, data[index1][j]);
            }

            xStart += barSize;
        }
    }

    public int findExactFrequencyCount(int index1, int index2, int value)
    {
        int count = 0;

        for (int i = 0; i < index1; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                if (data[i][j] == value)
                    count++;
            }
        }

        for (int j = 0; j <= index2; j++)
        {
            if (data[index1][j] == value)
                count++;
        }

        return count;
    }

    public boolean imageUpdate(Image img, int infoflags,
        int x, int y, int width, int height)
    {
        return true;
    }
}
