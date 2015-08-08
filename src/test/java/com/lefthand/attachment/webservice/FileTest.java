package com.lefthand.attachment.webservice;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by wangmz on 2015/7/23.
 */
public class FileTest {

    public static void main(String[] args) throws Exception{
        File file = new File("E:/test/222.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] buffer = IOUtils.toByteArray(inputStream);

//        String base64str = Base64.encodeBase64String(buffer);
        String base64str = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgKCgkICQkKDA8MCgsOCwkJDRENDg8QEBEQCgwSExIQEw8QEBD/2wBDAQMDAwQDBAgEBAgQCwkLEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBD/wAARCADcAZADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDzqpJvup/u0uy3/wCep/75qSVYMJmQjj0oAhh/1i/Wkl/1jfWpo1t94xISc+lJItvvOZT19KAGw/ck+lRVaiWDY+JDjHPFRbLf/nqf++aALV5/yDrb8aop99frWndLD9gtwZDjnBxVJFt9wxKevpQAy4/1ppbfq3+7Uk6weYd0hB+lLCsGW2yE8elAFU9alP8Ax7j60bLf/nqf++alKweT/rDjPpQBVHWpJ/vL/uinBbfP+tP/AHzT5lg3DMh6elAEmkf8fg+hqrP/AK5/941e0tYRdjbIScHtVaZbfzXzKep7UAMT/UN9aiq0qweS2JDj6VFst/8Anqf++aACb7q/Smw/6wVNKsGFzIenpSRrBvGJT+VAEMv+sb61JD9x/pSyLb7zmU5z6U+JYNj4kPT0oAq1oXX/ACDYPrVTZb/89T/3zV+5WH+z4AZDjPXFAGYn3h9afP8A6005Vt9wxKfyp8yweYcyEH6UAR2/VvpUR61ZhWAE4kJ49KYVt8/60/8AfNACH/j3H1qIdR9aslYPJ/1hxn0pgW3z/rT+VACXH3h9Kn0n/j8X6GmTLASN0hHHpVjS1hF2NshJwe1AFK4/18n+8aVP9Q31qSdbfznzKfvHtSqsHktiQ4+lAFWpZvup9KNlv/z1P/fNSyrBtXMh6elAEEP+sFJL/rG+tTRrBvGJT+VJItvvOZTn6UANh+6/0qKrUSwbWxIenpUWy3/56n/vmgC3cf8AILg+tUF+8K07hYf7NgBkOM9cVRVbfI/en8qAGT/6w062++f900+ZbfecyH8qdAsG47ZCTg9qAKp61L/y7n60pW3z/rT+VP2weR/rDjPpQBWHWpbj7y/7opQtvn/Wn/vmpJ1gyMyHoO1AC6V/x+p+NV5/9c/+8au6YsAvE2yEnntUE62/nPmU/ePagCtUk33U/wB2l89f+eCfrUksy7VzCp4oAhh/1i/Wkl/1jfWpoplMgHkqOaSSZQ7fuV6+9ADYfuSfSoqtRTKUf90owKi89f8Angn60AWrz/kHW341RT76/WtO7lUWFufKU5zxVFJlLD9wnX3oAbcf600tv1b/AHaknmUSEeSppYJlJb9yo4oAqnrUp/49x9aDOuf9Qn61KZl8gHyV60AVR1qSf7y/7opROuf9Qn61JPMoYfuVPHvQBJpH/H4Poaqz/wCuf/eNXtKlVrsDylHBqtNMvnP+4TqfWgBif6hvrUVWlmXyWPkr+tReev8AzwT9aACb7q/Smw/6wVNLMoVf3K9KSKZS4/crQBDL/rG+tSQ/cf6UskyhyPJXrT4ZlKP+5UfnQBVrQuv+QbB9aqeev/PBP1q/dSqNPgPlL16UAZifeH1p8/8ArTTlmXcP3KU6aZRIR5KmgBlv1b6VEetWYJlJP7lRxUZnXP8AqE/WgAP/AB7j61EOo+tWjMvkZ8pevSohMuR+5T9aAC4+8PpU+k/8fi/Q0yeZQRmFTxU+lyq12AIlHB6UAU7j/Xyf7xpU/wBQ31qS4mXz3/cr94+tKsy+Sx8laAKtSzfdT6Ueev8AzwT9almmUKn7lelAEEP+sFJL/rG+tTRTKXH7laSWZfMI8lTQA2H7r/SoqtQzKVf9yo496i89f+eCfrQBbuP+QXB9aoL94Vp3Eq/2bC3lLyelUVnXcP3CfrQAyf8A1hp1t98/7pp80yhz+5U06CZSxHkqOD60AVT1qX/l3P1oM65/1CfrUvnL5GfJXr0oAqjrUtx95f8AdFAnXP8AqE/WpZ5lBX9yp496AF0r/j9T8arz/wCuf/eNXdLmU3iAQqPeq88y+c/7lPvH1oAh8qT+4alljk2p8p6VH503/PVvzqSWWUKmJG6etADYY5PMX5D1pJI5PMb5D1pYpZTIAZG6+tEk0odgJG6+tADoY3CSfKelReVJ/cNTQyyFJCZG4HrUXnTf89W/OgC9dxudPtgFPGapJHJvHyHrV67lkGn2xEjZOe9UUml3j943X1oAdPG5lJCmlgjcFsqelE8solIEjfnSwSyktmRjx60AQmKTP3DUpjk8gDYetRmaXP8ArW/OpTLL5APmNnPrQBCIpM/cNSTxybh8h6CmCaXP+tb86knllDDEjDgd6AJ9JjcXYJU9DVaeKTzn+Q9TVrSZZGvADIx4Peq080vnP+8bqe9ACpG/ksNpqLypP7hqZJZfJY+Y2frUXnTf89W/OgCSaOTavynpTYo5PMHyGnTSygLiRunrTYppTIMyN+dACSRSeY3yHrUkMbhH+U9KZJNKHbEjdfWnwyyFHzI3T1oAh8qT+4a0LpH/ALOgG05zVDzpv+erfnV+6kkGnQEO2c+tAFBIpNw+Q0+eOTzD8ppqzS7h+8b86dPLKJCBIw/GgBYI3y3ynpURikz9w1LBLKS2ZGPHrUZmlz/rW/OgCQxv5GNp61GIpMj5DUhlk8jPmNnPrUYmlyP3jfnQBJcRuWGFPSp9JjcXYJU9DUE8sgYYkYcetWNKlka7UNIx4PegCtcRyefJ8h+8aVI38lhtNJcTSieQCRvvHvTkll8lj5jZ+tAEPlSf3DUs0b7U+U9Kj86b/nq351LNLKFTEjdPWgBkUcnmD5DRLFJ5jfIaIppTIMyN+dEs0okYCRvzoAdDHJtf5T0qLypP7hqWGWUq+ZG6etR+dN/z1b86AL9wj/2ZANpzmqCxSbh8hq/cSyf2ZA29s565qis0u4fvG/OgBZo5C5+Q063jcMcqehpJppRIcSN+dLbyyliDIx4PegCIxSZ+4al8uTyMbD1qMzS5/wBa351J5svkZ8xs59aAIhFJn7hqW4jcsvynoKjE0uf9a351JPLKCuJGHA70ATaVG4vUJU96gnjk85/kP3jVjSpZTeoDIx696rzzSiZ8SN9496AE8mP/AJ7rUksSEJ++UcVWqSb7qf7tAEkcSBwRMp5pJIULnMy9ajh/1i/Wkl/1jfWgCxFEgRwJVORUXkx/891oh+5J9KioA07qNDYW4MqgDPNU1hQMMTL1qxef8g62/GqKffX60AWJ4kMhJmUUsMSAtiVTxUNx/rTS2/Vv92gBTDHn/XrTzEnk485cZ61WPWpT/wAe4+tACiGPP+vWnzRIWGZlHAqsOtST/eX/AHRQBd0uJFuwRKpODVaaFPNfMy9TUukf8fg+hqrP/rn/AN40ATrEnksPOWovJj/57rQn+ob61FQBaliQhf3yjj1psUSBxiZTTJvur9KbD/rBQBJJChc5mXrT4okCPiVTxVeX/WN9akh+4/0oATyY/wDnutX7mNTp8AMq9etZdaF1/wAg2D60AVVhj3D98tPmiQyEmZRVdPvD60+f/WmgCWGJATiZTxTDDHn/AF60lv1b6VEetAFoxJ5OPOXr1qMQx5H79aQ/8e4+tRDqPrQBZmiQsMyqOKn0uJFu1IlU8Gqlx94fSp9J/wCPxfoaAGTwxmZz5yj5jSrEnksPOWobj/Xyf7xpU/1DfWgA8mP/AJ7rUssSFVzMo4qrUs33U+lAD44UDjEymkkhQuSZlFRw/wCsFJL/AKxvrQBYiiQK+JlPFReTH/z3WiH7r/SoqANS4iQ6bAPNXGetUVhjyP361auP+QXB9aoL94UATyxIXOZlH40sESBiRKp4NQz/AOsNOtvvn/dNACmGPP8Ar1p/lJ5OPOXGetVj1qX/AJdz9aAFEMef9etPmiQkZlUcCqw61LcfeX/dFAFvS4kF4hEynrUE8MZmf98v3jTtK/4/U/Gq8/8Arn/3jQBd+1aR/wBA+T/vsVJJdaVhc2EhGOPnFZm1v7p/KpJVbanynp6UAXo7rSS4xYSA5/vike60kOc2EhOf74qhEreYvynr6USq3mN8p6+lAGjHc6UUfbYyDA5+cVH9q0j/AKB8n/fYqrCrbJOD0qLa390/lQBuXNxposoC1m5U5wNw4qot1pO4YsJOv98U27U/2fbDB71RRW3j5T19KANGa50oSENYyE/74pYbnSiW22Mg4/viqFwrGU4BpbdWBbIPSgC2brSP+fCT/vsU83OleUD9hkxnpvFZhVs/dP5VKVbyBwetAFv7VpH/AD4Sf99iny3OlBhusZDx/fFZgVs/dP5VJOrbh8p6DtQBq6bcaY1yBFZOrYPO8VBLdaSJWBsJCc/3xUOkqReDIPQ1WnVvOf5T949qANBbnSvKYixkxnpvH+FR/atI/wCgfJ/32KqoreQ3BqLa390/lQBpy3WlALmxkPH98Ukd1pJcYsJAf98VRmVtq/KenpSRK3mD5T+VAF57rSQ5zYSE5/vinR3OllW22Mg4/vis6RW8xvlPX0p8Ktsfg9KALX2rSP8AoHyf99irtxcaaLGFms3Kk8DcOKw9rf3T+VaF0p/s2AYPWgAW60ncMWEn/fYp011pQc7rCQn/AHxWcituHyn8qdOreYflP5UAaEN1pRJ22Mg4/vimG60j/nwk/wC+xVOBWy3B6VGVbP3T+VAGmbnSvJz9hkxnpvFMF1pOf+PCT/vsVUKt5A4PWogrZHyn8qANOa50oEbrGQ8f3xU2nXOmNcgR2TqcHkuKy7hW3Dg9Kn0lWF4uQehoAmmutKErhrCQnccneKVbnSvKYixkx6bxVC4VvPk+U/ePalRW8huDQBa+1aR/0D5P++xUktzpQVd1jIeP74/wrM2t/dP5VLMrbU4PSgC5HdaSXGLCQH/fFEl1pIc5sJCf98VRiVvMHyn8qSVW8xvlP5UAaMVzpRVttjIOP74qP7VpH/QPk/77FVYVba/B6VFtb+6fyoA3J7jTRp8LNZuUJ4XcOKpi60nIxYSf99ii4B/suAYPWqCq24fKfyoA0ZbrSQ+DYSE/74pYbnSix22Mg4P8YrPmVvMPyn8qdbqQ5yD0NAFs3Wkf8+En/fYp/wBp0ryc/YZMZ6bx/hWYVbP3T+VSbT5GMHrQBc+1aR/z4Sf99inzXOlAjdYyHj++KzArZ+6fyqW4Viy8HoKANPTrnTGu0Edk6t6lxUM11pIlcNYSE5OfnFQaUrfbU+U9+1V51bzn+U/ePagA+0zf3h+QqSWeUKhDDkegpn2Z/VfzqSW3chBkcD1oAbFcSmQAsOvoKSS4lDsAw6+gp0du4cHK9fWkktnLk5Xr60AOinkKOSw4HoKi+0zf3h+QqaKBwjjI5HrUX2Z/VfzoAvXc0g0+3YEZOe1UkuJSwBYdfQVduoHNhbqCOM96prbOGByOvrQAs9xKshAYfkKWCeRi2SOnoKJ7d2kJBH50sNu6luRyPWgCI3MufvD8hUhnl8gHIzn0phtn9V/OpDbv5O3I6+tAEQuZc/eH5CnzTyhhhh0HYU0Wz56r+dPmt3LDkdB3oAn0qeRrsBiMYPaq01xKJXG4dT2FWtKgdbsEkdD3qtNbOZXOV6nvQAqzy+SxyM/SovtM394fkKmW3cRMMjn3qL7M/qv50ASSzygKQR09KbFcSlwCw/IU6W3chcEdPWkit3Dgkj86AGyXEocgMOvoKfFPIyPlv0psls5cnK9fWnxQOqsMjketAEP2mb+8PyFX7qaQadAwIzn0qj9mf1X86v3MDnT4FyM59aAKC3EpYDcPyFPmuJRIQGH5CmrbPuHK/nT5rd2kJBX86ACGeVi2WHT0qM3MufvD8hUkNu6k5I6etMNs+eq/nQA8zyeTuyM59KjFxLkfMPyFSm3fyQMjr61GLZ8jlfzoAfPPKrDDdvQVPpc0j3ahm7HtUE0DswwR09an0uB0u1JI6HvQBXnuJRM4DD7x7ClWeXyWORn6UT2zmZzleWPelW3cRMMj86AIftM394fkKlmnlAUgjkelR/Zn9V/OpZbdyq4I4HrQAyK4lLgFh+QpJLiUOQGH5CnR27hwcr+dJJbuXJyv50AOinlKtlhwPSovtM394fkKligdVbkcj1qP7M/qv50AXriaQaZAwIyT6VRW4lyPmH5Cr9xA502Bcjg+tUVtnBHK/nQAs1xKHIDD8hToJ5WYgkdD2FJLbuzkgj86WC3dWJyOh70ARm5lz94fkKk8+XyN2RnPoKYbZ89V/On/AGd/J25HX1oAjFzLn7w/IVJPPIpXBHQdhTBbPnqv50+a3diOR0HegCbS55WvUBI79qgnuJRM43D7x7CrGl27reISR371BPbOZnOV+8e9AFapJvup/u07Fr/ef8qfKLfamWbp6UAQw/6xfrSS/wCsb61NGLbeMM2c+lEgtt5yzZz6UAMh+5J9Kiq1ELfY+GbGOeKjxa/3n/KgCzef8g62/GqKffX61p3Qg+wW+WbHOOKpKLbcMM2c+lADLj/Wmlt+rf7tSTC38w7mbP0pYRb5bazdOeKAKp61Kf8Aj3H1pSLXP3n/ACqQi38n7zYz6UAVR1qSf7y/7opwFrn7z/lT5hb5G5m6elAEmkf8fg+hqrP/AK5/941e0sQfaxsZs4PUVXmFt5r5Z+p7UARp/qG+tRVaUW/kthmxn0qPFr/ef8qAEm+6v0psP+sFTyi3wuWbp6U2IW28YZvyoAhl/wBY31qSH7j/AEpZBbbzlmzn0p8Qt9rbWbp6UAVa0Lr/AJBsH1qri1/vP+VXrkQf2fBktjPpQBmJ94fWnz/6009Rbbhhm/KnTC38w7mbP0oAjt+rfSoj1q1CLfJ2s3T0qMi1z95/yoAQ/wDHuPrUQ6j61aIt/J+82M+lRgWuR8z/AJUAJcfeH0qfSf8Aj8X6GmzC33DczdPSp9LEH2sbGbOD1FAFK4/18n+8aVP9Q31qScW3nPlmzuPalUW/lNhmx9KAKtSzfdT6UuLX+8/5VJKLfau5m6elAEEP+sFJL/rG+tTRi23jDNn6USC23nLNn6UAMh+6/wBKiq1ELfa20t09Kjxa/wB5/wAqALVx/wAguD61QX7wrTuBB/ZsGWbbn0qiotcj5n/KgBk/+sNOtvvn/dNSSi23nczflSwC33HazZwe1AFU9al/5dz9aUi1z95/yp+LfyfvNjPpQBWHWpbj7y/7opQLXP3n/KpJhb5G5m6DtQAulf8AH6n41Xn/ANc/+8au6WLf7Ym1mzz2qCcW3nPln+8e1AFapJvup/u0v2k/880/KpJZyAn7tOnpQBDD/rF+tJL/AKxvrU0VwS4Hlp19KSS4Icjy06+lADYfuSfSoqtRTko52KMD0qL7Sf8Anmn5UAWrz/kHW341RT76/WtO7nIsLdti85qklwSwHlp19KAGXH+tNLb9W/3akmnKyEeWn5UsM5Yt+7TgelAFU9alP/HuPrSm4Of9Wn5VIZz5O7y16+lAFUdakn+8v+6KcLg5/wBWn5U+achh8iHj0oAk0j/j8H0NVZ/9c/8AvGr2lTlrsDYo4PQVWmuCJXHlp1PagBif6hvrUVWlnJiY+Wv5VF9pP/PNPyoAJvur9KbD/rBU0s5AX92vT0pIrglwPLT8qAIZf9Y31qSH7j/SlkuCHI8tOvpT4pyyN8ij8KAKtaF1/wAg2D61U+0n/nmn5VfuZiNPgbYvJoAzE+8PrT5/9aactwSwHlp+VPmnIkI8tPyoAjt+rfSoj1qzDOWLfu06elMNwc/6tPyoAQ/8e4+tRDqPrVoznyd3lr19KjFwcj92n5UAJcfeH0qfSf8Aj8X6GmTTlWHyIePSrGlzFrtRsUcHoKAKVx/r5P8AeNKn+ob61JPcETOPLT7x7UqzkxMfLX8qAKtSzfdT6UfaT/zzT8qllnICny15HpQBBD/rBSS/6xvrU0VwS4Hlp+VJJcEOR5aflQA2H7r/AEqKrUU5Kt+7TgelRfaT/wA80/KgC3cf8guD61QX7wrTuJiNNgbYvX0qitwcj92n5UAMn/1hp1t98/7pp81wQ5Hlp+VLBOWYjy0HB7UAVj1qX/l3P1pTcHP+rT8qf558nd5adfSgCsOtS3H3l/3RS/aD/wA80/KpJpypX92p4HagBdK/4/U/Gq8/+uf/AHjV3S5y14g8tR17VBPcETOPLT7x7UAL/Zd//wA+7VJLpl8QgFu3Aqr9quf+fiX/AL7NSy3NztT/AEiTp/fNAEkWl3wkBNu3Wkk0u+Lki3brUUVzcmRc3EnX++aSS5ufMb/SJev980AWYtMvgjgwNyKi/su//wCfdqIbm4KSZuJOn981D9quf+fiX/vs0Aal1p141hboISSuciqaaXfBwTbt1qe7uJxp9sRPICc5O41SS5ud4/0iXr/fNAFifTL5pCRbtilg0y+Utm3bpUE9zciUgXEn/fZpYLm4JbNxJ0/vmgBx0u/z/wAe7VIdMvvJC/Z2zmqpurnP/HxL/wB9mpDc3HkA/aJM5/vmgBw0u/z/AMe7U+bTL4sCLdulVhdXOf8Aj4l/77NST3NyGGLiToP4zQBd0vTr2O6DPAwGDVabS74yuRbtjJqTSri4a7AaeQjB6saqzXNyJXAuJOp/jNAFhdMvhCw+ztk1F/Zd/wD8+7UiXNz5LH7RJ/32ai+1XP8Az8S/99mgC3Lpl8VXFu3SmxaXfBwTbtUc1zcgLi4k6f3zTYrm58wf6RL/AN9mgCWTS74uSLdutPh0y+CMDbtzVaS5ufMb/SJev981JDc3BR83En/fZoAP7Lv/APn3ar9zp142nwoIG3A8isr7Vc/8/Ev/AH2a0Lq4nGnQMJpASeu40AVl0u/3D/R2p82l3xkJFu1V1ubncP8ASJf++zTp7m5EhxcSf99mgCeHTL4E5t25FRnS7/P/AB7tTYLm5JbNxJ0/vmozdXOf+PiX/vs0AWjpl8YMfZ2zmoxpd/kf6O1NNzceQD9okzn++ajF1c5H+kS/99mgC1Ppl8WBFu3SptM069jugzwMBg1TuLm5DDFxJ0/vmp9KuLhrsBp5CMHqxoAbPpd8ZnIt2wWNKumXwhYfZ2yaguLm5E8gFxJ94/xmlS5uPJY/aJP++zQAv9l3/wDz7tUs2mXxVcW7cCqn2q5/5+Jf++zUs1zchUxcSdP75oAki0u+Dgm3aiXS74uSLdqhiubkyDNxJ/32aJbm5EjYuJP++zQBYi0y+Cvm3bkVF/Zd/wD8+7UkNzcFXzcSdP75qL7Vc/8APxL/AN9mgDUn0+8OnQxiFiwPIqkul3+4f6O1Wbi4nGmQMJpMk9dxqgt1c7h/pEv/AH2aALE2mXxckW7U6DTL5WJNu3Q1BNc3IkOLiT/vs0tvc3Bc5uJDwf4zQA46Xf5/492qT+zL7yNv2ds5qqbq5z/x8S/99mpPtNx5GftEmc/3zQA4aXf5/wCPdqkn0y+YjFu3QVVF1c5/4+Jf++zUk9zcAri4k6D+M0AXNM029jvEZ4GAFQT6XfGZyLdiCTS6XcXDXqBp5COerGoJ7m5EzgXEn3j/ABmgBvlQ/wDPcU+WOIqmZgOKrVJN91P92gCSKKISAiYHmiSKIuczgc1FD/rF+tJL/rG+tAFiKOII+Jgcio/Kh/57ikh+5J9KioA1LqOM2FuDKABnmqSRQ7hicdasXn/IOtvxqin31+tAFiaKIyEmYA0sMcQLYmB4qG4/1ppbfq3+7QApihz/AK8VIY4vJA84Yz1qqetSn/j3H1oAURQ5/wBeKfNHEWGZgOKrDrUk/wB5f90UAXdLjiF2CswJwarzRRGV8zjqak0j/j8H0NVZ/wDXP/vGgCdY4vJYecMZ61H5UP8Az3FIn+ob61FQBaliiIXMwHFNiiiDjE4NMm+6v0psP+sFAEkkURckzAc0+KOIK2JgeKry/wCsb61JD9x/pQAeVD/z3FXrmOM6fADKAM9ay60Lr/kGwfWgCssUO4fvxTpoojISZgKrp94fWnz/AOtNAE0McQJxMDxUZihz/rxSW/VvpUR60AWjHF5OPOGM9ajEUOR+/FIf+PcfWoh1H1oAtTRxFhmYDip9LjjF2CswJwap3H3h9Kn0n/j8X6GgBk8UJmcmcD5jSrHF5TDzhj1qG4/18n+8aVP9Q31oAXyof+e4qSWOIquZgOKq1LN91PpQA+OKIOMTA0SRRFyTOBUUP+sFJL/rG+tAFiKOIK2JgeKj8qH/AJ7ikh+6/wBKioA1LiOP+zYAZRjPWqKxQ5H78VauP+QXB9aoL94UAWJYoi5zMBSwRxBjiYHg1BP/AKw062++f900AKYoc/68VJ5cXk484Yz1qqetS/8ALufrQAoihz/rxUk0cRIzMBwKqjrUtx95f90UAW9LjiF4hEwPWoJ4ofOf9+PvGnaV/wAfqfjVef8A1z/7xoAd5sP/ADw/WpJZIgEzDnj1qvsf+6allR9qfKelADopIi4xDjn1pJJYd5zD39aZEjiRflPWkkR/Mb5T1oAnikiKPiHGB61F5sP/ADw/WnQowST5T0qHY/8AdNAGndyRCwtyYsjnjNUklh3DEHf1q1do39n2w2nvVFEfePlPWgCaaSISEGHJ+tLDJES2IccetRXCMZThTSwIwLZU9KAAyw5/1H61IZIvJz5PGemarlHz901IUbyANp60AAlhz/qP1p80kQYZhzx61AEfP3TUk6MWGFPQUAW9KkiN2AsWDg96rTSw+a/7jue9TaSjC8BKnoarTo/nP8p6mgCVZIvKY+Tx6ZqLzYf+eH60qI3kt8pqLY/900AWJZIgFzDnj1pIpIi4xDj8abMj7V+U9KbEj+YPlNAD5JYQ5zD39afFJGUfEOOPWoJEfzG+U9akhVgj5U9KAG+bD/zw/Wr9zJGNPgJiyM9M1mbH/umtC6Vv7NgG09aAKiyw7h+4/WnzSRCQgw5/GoUR9w+U06dHMh+U0ASQyREtiHHHrTDLDn/UfrRAjAt8p6VGUfP3TQBYMkXk58njPTNRiWHI/cfrQUbyANp61GEfI+U0ATzSRBhmHPHrVjS5IzdqFiwcHvVS4Viwwp6VPpSsLxcqehoAjnlhEzgw5+Y96VZIvKY+Tx6ZqK4R/Pk+U/eNKiN5LfKaAE82H/nh+tSyyRALmHPHrVbY/wDdNSzI21PlPSgB0UkRcYhx+NJJJEHIMOfxpkSOJB8polRzIxCnrQBLFJEVbEOOPWo/Nh/54frSwowV8qelRbH/ALpoA07iSP8As2AmLjPTNUVlhyP3H61buFb+y4BtOc1QVH3D5TQBNNJCHOYc/jSwSRFiBDjg96jmR/MPymlt1YOcqehoADLDn/UfrT/Mi8nPk8Z6ZqAo+fumpNjeQRtPWgA82H/nh+tSTSRArmHPA71XCPn7pqS4Riy4U9BQBa0uSI3iAQ4696gnlh85/wBx/Ee9SaUjC9TKnvVedH85/lP3jQAn2ib++aklnlCphzyKb9mP/PRPzp8tuSqfOvT1oAZFPKZAC560STzB2Ac9adFbkSA716+tEluS5O9evrQAsU0pRyX6CovtE3981NFAQjjevI9aj+zH/non50AXLuaQafbEOcnNUknmLAFz1q/dQE2Fuu9eM96pJbEMDvTr60AE88qyEByBSwTSktlz0pZrctITvUfjSwwFS3zryPWgCE3E2fvmpDNL5AO85zTTbHP+sT86kMB8kLvXr60AQi4mz981JNPKGGHPQU0Wxz/rE/OnzW5Zh869PWgCfSppWuwGckYNVpp5hK/znqataXAVuwd6ng96rzW5MrnenU96AEWaUwsd5yKj+0Tf3zUywERMN68n1qP7Mf8Anon50AOlnlAXDnpTYp5S4Bc1JLbkhfnXp602O3IcHen50ANknmDsA560+KaUo5L9KSS3JcnevX1p0UBCsN68j1oAh+0Tf3zV+6mkGnQMG5zVL7Mf+eifnV65hJ0+Bdy8H1oAoLPNuHzmnTTyiQgOaFtiGHzp+dOmty0hO9fzoASCeUlsuelRm4mz981NDAVJ+denrUZtjn/WJ+dADjNL5AO85zUYuJsj5zUxgPk43r19ajFscj94n50AOnmlVhhyOKn0qaRrtQzk8GopoCzD51HHrU+lwFbsHep4PegCrPPKJ3Ac/eNKs0vksd5zSz25MznevLHvSrAREw3rz70AQ/aJv75qSaaUKmHPIpv2Y/8APRPzqSWAlV+deB60ARxTylwC5olnlEhAc06O3IcHev50SW5Lk71/OgAimlKvl+gqP7RN/fNTRQFVb515HrUf2Y/89E/OgC7cTSDTIGDnOaoLcTZHzmtC4gJ02Bdy9euaorbHI/eJ+dACzTyhyA5pYJpWYgvng0stuS5O9fzpYICrE71PB70AQm4mz981J58vkZ3nOaabY5/1ifnUnkHydu9evrQBCLibP3zUk80qlcPjgU0Wxz/rE/OpJoCxHzqOB3oAl0ueVr1AXJ61XnnmEzjefvGrOl25W8Q71PXvUE9sTM53p9496AK1STfdT/dq3u0T/nncfp/jUkraNhcx3GMcYx/jQBnw/wCsX60kv+sb61oRNo28YjuM59v8aSRtF3nMdxnPt/jQBTh+5J9KirUibR9j7UnxjnOP8ai36J/zzuP0/wAaAC8/5B1t+NUU++v1rbuW0r7FBvSbZztx1/nVRG0XcMR3Gc+3+NAFK4/1ppbfq3+7V6ZtG8w7o7jPtj/GiFtHy22O46d8f40AZh61Kf8Aj3H1q2X0XP8Aq7j9P8aeW0fyR8lxjPt/jQBmDrUk/wB5f90VcDaLn/V3H6f40+ZtG3DdHcdO2P8AGgCHSP8Aj8H0NVZ/9c/+8a19NbSTdDyknDYPXH+NV5W0bzW3R3Gc89P8aAKSf6hvrUVaato/lNhJ8d+n+NR79E/553H6f40AVZvur9KbD/rBWhK2jYXdHcdPb/GkjbRt4xHcZ/D/ABoAz5f9Y31qSH7j/SrcjaLvOY7jOfb/ABp8TaPtbbHPjvnH+NAGXWhdf8g2D60m/RP+edx+n+NXbhtK+ww70m2Z4x1/nQBiJ94fWnz/AOtNXFbRdwxHcfp/jTpm0bzDujuM+2P8aAKVv1b6VEetacLaNk7Y7jp3x/jTC2i5/wBXcfp/jQBUP/HuPrUQ6j61p7tH8nmO4xn2/wAaYG0XIxHcfp/jQBUuPvD6VPpP/H4v0NTzNo+RujuOnbH+NTaa2km5HlJOGweuP8aAMq4/18n+8aVP9Q31q7M2jec+6O4zk5xj/GlVtH8psR3GPw/xoAzKlm+6n0q1v0T/AJ53H6f41JK2j7V3Rz9OMf8A66AM+H/WCkl/1jfWr8baNvG2O4z+H+NEjaNvOY7jP4f40AU4fuv9KirTibR9rbY7jpz0/wAaj36J/wA87j9P8aAFuP8AkFwfWqC/eFbk7aV/Z8JZJtmeMdf51SVtFyMR3H6f40AUp/8AWGnW33z/ALpq7K2jbzujuM/h/jSwto+47I7jOO+P8aAMw9al/wCXc/WrZbRc/wCruP0/xp+7R/J+5cYz7f40AZg61LcfeX/dFWw+i5/1dx+n+NPmbR8jdHcdB0x/jQBX0r/j9T8arz/65/8AeNa2nNpJu08pJw3bP/66gmbRvNfdHcZyc4x/jQBm4PpUswO1P92j7S/91PyqSW4cBDtXkelAEMIPmL9aSUHzG471LFcOZANq9fSiS4cORtTr6UAJD9yT6VDg+lWop2KOdq8D0qL7S/8AdT8qALd4D/Z1tx61RQHeOO9aN3OwsLdtq857VSS4csBtTr6UANuAfNPFLbg5b6U+ad1kICr+VLDO7FsqvT0oArEHPSpSD9nHHeg3L/3U/KpDO/kg7V6+lAFYA56VLODuH0FAuXz91PyqSad1YYVenpQBJpAP2wfQ1VnB85+P4jV7Sp3a7AKr0PQVWmuHErjanU9qAGID5DcVFg+lWVncwsdq/lUf2l/7qflQATA7V47U2EHzBxU0s7gL8q9PSmxXDlwCq/lQBFKD5jcd6kh+4/0pZLhw5G1OvpT4p2ZGJVePagCrg+laF1/yDYPrVT7S/wDdT8qv3UzDT4GwvX0oAzEB3DjvT5wfMPFOW5fcPlT8qdNcOJCNq/lQAyAHLcdqiIOelWYZ3JOVXp6VGbl8/dT8qAAg/Zxx3qMA5HFWDO/kg7V6+lRi5fI+VPyoALj7w+lT6T/x+L9DTJp2VhhV6elT6XOzXagqvQ9BQBTuAfPk4/iNKgPkNxUk9w4mcbV4Y9qFncwsdq/lQBWwfSpZgdqcdqPtL/3U/KpJZ3Cr8q8j0oAhhB8wcUSg+Y31qSK4cuAVX8qJLhw5AVfyoAbD91/pUWD6VZindlbKrwPSo/tL/wB1PyoAt3H/ACC4PqaoKDuHFadxOw0yBtq5J9KorcvkfKn5UANnB8w8Utv98/Q0+a4cORtX8qWCdmYgqvQ9qAKxBz0qXB+z9O9BuXz91PyqTz38ndtXr6UAVgDnpUtwDuX/AHRR9pf+6n5VJNOykYVeQO1AD9KB+2px61XnB85+P4jVzS53a8QFV79qrz3DiZxtT7x7UAf/2Q==";
        byte[] contentbyte = Base64.decodeBase64(base64str);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(contentbyte);
        FileOutputStream outputStream = new FileOutputStream(new File("E:/test/999.jpg"));
        IOUtils.copy(byteArrayInputStream, outputStream);
        IOUtils.closeQuietly(outputStream);
        IOUtils.closeQuietly(inputStream);
    }
}
