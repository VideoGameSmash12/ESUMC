package me.videogamesm12.esumc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main
{
    private static final Map<String, UUID> users = new HashMap<>();

    public static void main(String[] args)
    {
        final File file = new File("usermap.csv");
        final File newFile = new File("usermap.bin");
        if (!file.exists())
        {
            System.out.println("Where's the fucking usermap, genius?");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(",");
                if (values.length != 2)
                {
                    continue;
                }

                System.out.println("Matching username " + values[0] + " with UUID " + values[1]);
                users.put(values[0], UUID.fromString(values[1]));
            }
        }
        catch (Exception ex)
        {
            System.out.println("AW SHIT");
            ex.printStackTrace();
        }

        try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream(newFile)))
        {
            for (final Map.Entry<String, UUID> entry : users.entrySet())
            {
                dos.writeUTF(entry.getKey());
                final UUID uuid = entry.getValue();
                dos.writeLong(uuid.getMostSignificantBits());
                dos.writeLong(uuid.getLeastSignificantBits());
            }
        }
        catch (Exception ex)
        {
            System.out.println("FUCK");
            ex.printStackTrace();
        }
    }
}
